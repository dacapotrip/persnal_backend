package com.persnal.persnal_backend.borad.domain.comment;

import lombok.Data;

@Data
public class CommentRequestDTO {
    private int postId;
    private String author;
    private String comment;
}
