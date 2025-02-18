package com.escaes.RestfullPractice.controller;

import com.escaes.RestfullPractice.models.Content;
import com.escaes.RestfullPractice.repository.ContentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ContentController {

    private final ContentRepository contentRepository;//-> O usar el autowired para inyectar la dependencia
    public ContentController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @GetMapping("")
    public ResponseEntity<?>getAll(){

        return ResponseEntity.ok(contentRepository.findALL());
    }

    @GetMapping("/id/{id}")
    public  ResponseEntity<?>getContentById(@PathVariable Integer id){

        return ResponseEntity.ok(contentRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("No se encontró contenido con el id:"+id)));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?>getContentByTitle(@PathVariable String title){
        return ResponseEntity.ok(contentRepository.findByTitle(title)
                .orElseThrow(()->new RuntimeException("No se encontró contenido con el título:"+title)));
    }

    @PostMapping("")
    public ResponseEntity<?>createContent(@RequestBody Content content){
        if(contentRepository.isPresent(content.id()) || contentRepository.findByTitle(content.title()).isPresent()){
            return ResponseEntity.badRequest().body("El contenido ya existe con el id o título");
        }
        contentRepository.save(content);
        return ResponseEntity.ok("Contenido creado");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>updateContent(@RequestBody Content content){
        if(!contentRepository.isPresent(content.id())){
            return ResponseEntity.badRequest().body("El contenido no existe");
        }
        contentRepository.save(content);
        return ResponseEntity.ok("Contenido actualizado");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContent(@PathVariable Integer id){
        if(!contentRepository.isPresent(id)){
            return ResponseEntity.badRequest().body("El contenido no existe");
        }
        contentRepository.delete(id);
        return ResponseEntity.ok("Contenido eliminado");
    }

}
