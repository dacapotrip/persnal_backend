package com.persnal.persnal_backend.borad.domain;

import lombok.Data;

@Data
public class PostResponseDTO {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private String passward;
    private String boardType;      
    private Integer views;          
    private Integer recommendations;
    private String createdAt;
    private String updatedAt;
}
