package com.lec.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder  // builder pattern 사용 가능
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subject; // 제목
    @Column(columnDefinition = "LONGTEXT")
    private String content; // 내용
    private LocalDateTime regDate; // 작성일
    @ColumnDefault(value = "0")
    @Column(insertable = false)
    private Long viewCnt; // 조회수

    // Post : User = N : 1
    @ManyToOne
    private User user;   // 글 작성자 (FK)

    // 첨부파일
    // Post : Attachment = 1 : N
    @ToString.Exclude
    @Builder.Default   // builder 제공안함
    @OneToMany
    private List<Attachment> fileList = new ArrayList<>();

}