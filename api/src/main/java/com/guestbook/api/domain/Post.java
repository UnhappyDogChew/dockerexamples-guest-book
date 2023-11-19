package com.guestbook.api.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@Entity
@ToString
@Table(name = "post")
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "content", length = 100)
    private String content;
    @Column(name = "name", length = 20)
    private String name;

    public Post() {
    }
}
