package com.guestbook.api.controller;

import com.guestbook.api.domain.Post;
import com.guestbook.api.dto.AddPostDto;
import com.guestbook.api.repository.PostRepository;
import com.guestbook.api.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @PostMapping("/add")
    public String addPost(@ModelAttribute AddPostDto postDto, HttpServletResponse resp) {
        Post post = new Post();
        post.setName(postDto.getName());
        post.setContent(postDto.getContent());
        log.info("new post: " + post);
        postService.savePost(post);
        resp.setHeader("Access-Control-Allow-Origin", "*");

        return "success (id: " + post.getId() + ")";
    }

    @GetMapping
    public List<Post> getPosts(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable long id) {
        return postService.getPost(id).orElse(new Post() {{
            setId(0);
            setName("Error");
            setContent("no such post");
        }});
    }
}
