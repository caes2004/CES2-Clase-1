package com.escaes.RestfullPractice.repository;

import com.escaes.RestfullPractice.models.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentRepository {

    private final List<Content> contents = new ArrayList<>();

    public List<Content> findALL() {
        return contents;
    }
    public Optional<Content> findByid(Integer id){

        return contents.stream().filter(c->c.id().equals(id)).findFirst();
    }
    public Optional<Content> findByTitle(String title){
        return contents.stream().filter(c->c.title().equalsIgnoreCase(title)).findFirst();
    }
    public void save(Content content){
        contents.removeIf(c->c.id().equals(content.id()));
        contents.add(content);
    }
    public boolean isPresent(Integer id){
        return contents.stream().anyMatch(c->c.id().equals(id));
    }

    public void delete(Integer id){

        contents.removeIf((c->c.id().equals(id)));
    }
}
