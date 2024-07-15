package com.lec.spring.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long post_id;  // 어느글의 첨부파일? (FK)

    @Column(nullable = false)
    private String sourcename;   // 원본 파일명
    @Column(nullable = false)
    private String filename;  // 저장된 파일명 (rename 된 파일명)

    private boolean isImage;   // 이미지 여부

}