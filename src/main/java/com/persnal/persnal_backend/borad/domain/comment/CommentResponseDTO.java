package com.persnal.persnal_backend.borad.domain.comment;

import lombok.Data;

@Data
public class CommentResponseDTO {
    private int id;
    private String author;
    private String comment;
}
