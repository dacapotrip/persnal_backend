package com.persnal.persnal_backend.borad.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.persnal.persnal_backend.borad.domain.PostRequestDTO;
import com.persnal.persnal_backend.borad.domain.PostResponseDTO;
import com.persnal.persnal_backend.borad.domain.comment.CommentRequestDTO;
import com.persnal.persnal_backend.borad.domain.comment.CommentResponseDTO;

@Mapper
public interface BoradMapper {
    
    public void saveRow(PostRequestDTO params);

    public List<PostResponseDTO> findByBoardType(String boardType);

    public PostResponseDTO findRow(Map<String, Integer> map);

    public void incrementRow(int id);

    public void incrementLikeRow(int id);

    public void saveComment(CommentRequestDTO params);

    public List<CommentResponseDTO> findCommentsByPostId(int postId);

    public void deletePostById(int id);
}
