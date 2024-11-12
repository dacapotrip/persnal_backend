package com.persnal.persnal_backend.borad.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persnal.persnal_backend.borad.dao.BoradMapper;
import com.persnal.persnal_backend.borad.domain.PostRequestDTO;
import com.persnal.persnal_backend.borad.domain.PostResponseDTO;
import com.persnal.persnal_backend.borad.domain.comment.CommentRequestDTO;
import com.persnal.persnal_backend.borad.domain.comment.CommentResponseDTO;


@Service
public class BoradService {

    @Autowired
    private BoradMapper boradMapper;

    public void create(PostRequestDTO params) {
        System.out.println("debug >>> service findAll"+ boradMapper);
        boradMapper.saveRow(params);
    }

    public List<PostResponseDTO> getPostsByBoardType(String boardType) {
        return boradMapper.findByBoardType(boardType);
    }

    public PostResponseDTO find(Map<String, Integer> map) {
        System.out.println("debug service find" + boradMapper);

        PostResponseDTO result = boradMapper.findRow(map);

        return result;
    }
    
    public void incrementViews(int id) {
        System.out.println("debug service sucess" + boradMapper);
        boradMapper.incrementRow(id);
    }

    public void incrementLike(int id) {
        System.out.println("debug service sucess" + boradMapper);
        boradMapper.incrementLikeRow(id);
    }

    public void addComment(CommentRequestDTO commentRequestDTO) {
        boradMapper.saveComment(commentRequestDTO);
    }

    public List<CommentResponseDTO> getCommentsByPostId(int postId) {
        return boradMapper.findCommentsByPostId(postId);
    }

    public void deletePost(int id) {
        boradMapper.deletePostById(id);
    }
}
