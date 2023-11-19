package com.guestbook.api.dto;

import lombok.Data;

@Data
public class AddPostDto {

    private String name;
    private String content;
}
