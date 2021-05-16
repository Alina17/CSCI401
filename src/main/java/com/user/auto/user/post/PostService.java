package com.user.auto.user.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repo;

    public Post create(Post post) {
        return repo.save(post);
    }

    public List<Post> getAll() {
        return repo.findAll();
    }

}
