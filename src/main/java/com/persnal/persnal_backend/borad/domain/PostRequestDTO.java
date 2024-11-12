package com.persnal.persnal_backend.borad.domain;


import lombok.Data;

@Data
public class PostRequestDTO {
    private String title;
    private String content;
    private String author;
    private String boardType;
}
