package com.lec.spring.domain;

import com.lec.spring.listener.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
//@EntityListeners(value = AuditingEntityListener.class)
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;   // null 허용
    private Long authorId;     // null 허용
//    private Long publisherId;

    @OneToOne(mappedBy = "book")  // 해당 Entity 의 테이블에선 연관키를 가지지 않는다.
    @ToString.Exclude  // lombok 의 ToString 에서 배제 (양방향에서의 순환참조 때문에)
    private BookReviewInfo bookReviewInfo;


    // Book:Review = 1:N
    @OneToMany
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    // Book:Publisher = N:1
    @ManyToOne
    @ToString.Exclude
    private Publisher publisher;


//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

//    @PrePersist
//    public void prePersist(){
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }

}