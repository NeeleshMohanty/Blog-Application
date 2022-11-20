package com.springboot.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.Blog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
