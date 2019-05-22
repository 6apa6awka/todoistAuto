package com.first.todoistauto.services;

import com.first.todoistauto.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private RequestService requestService;

    @Autowired
    private ParseService<TaskEntity> parseService;

    public List<TaskEntity> getAllTasks () {
        String response = requestService.getAllTasks();
        return parseService.parseResponse(response, TaskEntity.class);
    }
}
