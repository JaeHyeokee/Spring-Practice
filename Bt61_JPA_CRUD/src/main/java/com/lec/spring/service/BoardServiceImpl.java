package com.lec.spring.service;


import com.lec.spring.domain.Post;
import com.lec.spring.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    PostRepository postRepository;

    @Override
    public int write(Post post) {
        post.setRegDate(LocalDateTime.now());
        postRepository.save(post);
        return 1;
    }

    @Override
    public Post detail(Long id) {
        postRepository.incViewCnt(id);
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> list() {
        return postRepository.findAll();
    }

    @Override
    public Post selectById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public int update(Post post) {
        Post prevPost = postRepository.findById(post.getId()).orElse(null);
        if (prevPost != null) {
            post.setRegDate(prevPost.getRegDate());
            post.setViewCnt(prevPost.getViewCnt());
        }
        postRepository.save(post);
        return 1;
    }

    @Override
    public int deleteById(Long id) {
        postRepository.deleteById(id);
        return 1;
    }
}   // end Service