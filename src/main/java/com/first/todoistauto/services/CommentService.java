package com.first.todoistauto.services;

import com.first.todoistauto.entity.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    RequestService requestService;

    @Autowired
    private ParseService<CommentEntity> parseService;

    public List<CommentEntity> getCommentsByTaskId(Long taskId) {
        String response = requestService.getCommentsByTaskId(taskId);
        return parseService.parseResponse(response, CommentEntity.class);
    }
}
