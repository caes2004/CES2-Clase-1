package com.escaes.RestfullPractice.config;

import com.escaes.RestfullPractice.models.Content;
import com.escaes.RestfullPractice.models.Status;
import com.escaes.RestfullPractice.models.Type;
import com.escaes.RestfullPractice.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;

@Component
public class ContentInit implements CommandLineRunner {
    private final ContentRepository contentRepository;
    public ContentInit(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        if(contentRepository.findALL().isEmpty()){
            Content content =new Content(
                    1,
                    "Blog about new elements of Java",
                    "This blog is a new release of the new",
                    Status.IDEA,
                    Type.BLOG,
                    LocalDateTime.now(),
                    null,
                    "myurl.com");
            contentRepository.save(content);
            Content content2 =new Content(
                    2,
                    "Blog about Python new advances",
                    "This blog is a new release of the Python world",
                    Status.COMPLETED,
                    Type.TUTORIAL,
                    LocalDateTime.now(),
                    null,
                    "pythonurl.com");
            contentRepository.save(content2);

            Content content3 =new Content(
                    3,
                    "Blog about new elements of Java",
                    "This blog is a new release of the new",
                    Status.IDEA,
                    Type.BLOG,
                    LocalDateTime.now(),
                    null,
                    "myurl.com");
            contentRepository.save(content3);
        }
    }
}
