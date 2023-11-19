package com.guestbook.api.service;

import com.guestbook.api.domain.Post;
import com.guestbook.api.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;
    public long savePost(Post post) {
        repository.save(post);
        return post.getId();
    }

    public Optional<Post> getPost(long id) {
        return repository.findById(id);
    }

    public List<Post> getAllPosts() {
        return repository.findAll();
    }
}
