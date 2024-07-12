package com.lec.spring.service;

// Service layer
// - Business logic, Transaction 담당
// - Controller 와 Data 레이어의 분리

import com.lec.spring.domain.Post;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardService {

    // 글 작성
    int write(Post post);

    // 특정 id 의 글 조회
    // 트랜잭션 처리
    // 1. 조회수 증가 (UPDATE)
    // 2. 글 읽어오기 (SELECT)
    @Transactional
    Post detail(Long id);

    // 글목록
    List<Post> list();

    // 특정 id 의 글 읽어오기 (SELECT)
    // 조회수 증가 없음
    Post selectById(Long id);

    // 특정 id 글 수정하기 (제목, 내용)  (UPDATE)
    int update(Post post);

    // 특정 id 글 삭제하기 (DELETE)
    int deleteById(Long id);
}