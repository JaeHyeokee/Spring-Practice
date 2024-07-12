package com.lec.spring.repository;

import com.lec.spring.domain.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
    // TODO :
    //  가급적 기본 JPA 메소드로만 구현해보세요
    //  필요하면 query method 선언해서 사용해도 됨.

    @Modifying
    @Transactional
    @Query("UPDATE TBL_POST p SET p.viewCnt = p.viewCnt + 1 WHERE p.id = :id")
    void incViewCnt(Long id);
}