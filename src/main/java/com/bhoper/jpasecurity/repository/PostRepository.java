package com.bhoper.jpasecurity.repository;

import com.bhoper.jpasecurity.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
