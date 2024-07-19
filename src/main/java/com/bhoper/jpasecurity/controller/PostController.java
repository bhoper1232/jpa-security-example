package com.bhoper.jpasecurity.controller;

import com.bhoper.jpasecurity.exception.NotFound;
import com.bhoper.jpasecurity.model.Post;
import com.bhoper.jpasecurity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    @GetMapping
    public Iterable<Post> findAll() {
        return this.postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Long id) {
        return this.postRepository.findById(id).orElseThrow(() -> new NotFound("Post was not found"));
    }

}
