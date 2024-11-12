package com.persnal.persnal_backend.borad.ctrl;


import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persnal.persnal_backend.borad.domain.PostRequestDTO;
import com.persnal.persnal_backend.borad.domain.PostResponseDTO;
import com.persnal.persnal_backend.borad.domain.comment.CommentRequestDTO;
import com.persnal.persnal_backend.borad.domain.comment.CommentResponseDTO;
import com.persnal.persnal_backend.borad.service.BoradService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("board")
public class BoradController {

    @Autowired
    private BoradService boradService;
    
    @PostMapping("/{boardType}")
    public ResponseEntity<Void> save(@RequestBody PostRequestDTO params) {
        System.out.println("client endpoint : /board/posts");
        System.out.println("params = " + params);
        boradService.create(params);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{boardType}")
    public ResponseEntity<List<PostResponseDTO>> getBoardPostsByType(@PathVariable String boardType) {
        System.out.println("client endpoint : /board/{boardType}");
        System.out.println("{boardType} = " + boardType);
        List<PostResponseDTO> posts = boradService.getPostsByBoardType(boardType);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{boardType}/{id}")
    public ResponseEntity<PostResponseDTO> view(@PathVariable("id") Integer id) {
        System.out.println("client endpoint : /board/{boardType}/{id}");
        System.out.println("params = " + id);

        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        PostResponseDTO result = boradService.find(map);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @PutMapping("/{boardType}/{id}/views")
    public ResponseEntity<Void> incrementViews(@PathVariable int id) {
        boradService.incrementViews(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{boardType}/{id}/like")
    public ResponseEntity<Void> incrementLike(@PathVariable int id) {
        boradService.incrementLike(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/comments")
    public void addComment(@RequestBody CommentRequestDTO commentRequestDTO) {
        boradService.addComment(commentRequestDTO);
    }

    @GetMapping("/comments/{postId}")
    public List<CommentResponseDTO> getCommentsByPostId(@PathVariable int postId) {
        return boradService.getCommentsByPostId(postId);
    }
    
    @DeleteMapping("/{boardType}/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id) {
        System.out.println("params : " + id);
        boradService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    
}