package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Getter @Setter
public class PostDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String createdBy;
    private LocalDateTime createdOn;

    @OneToOne
    //@MapsId
    @JoinColumn(name = "post_id")
    private Post post;
}
