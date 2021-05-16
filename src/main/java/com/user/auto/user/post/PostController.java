package com.user.auto.user.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @PostMapping
    Post createPost(@RequestBody Post post) {
        log.info("got here");
        return service.create(post);
    }

    @GetMapping
    List<Post> getAll() {
        return service.getAll();
    }

}
