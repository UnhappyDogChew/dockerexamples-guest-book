package com.guestbook.api.repository;

import com.guestbook.api.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, Long> {
}
