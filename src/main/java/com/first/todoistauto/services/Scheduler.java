package com.first.todoistauto.services;

import com.first.todoistauto.entity.CommentEntity;
import com.first.todoistauto.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private GoogleCalendarAuthorize googleCalendarAuthorize;

    @Scheduled(fixedDelay = 900000)
    public void printCurTime() {
        for (TaskEntity task : taskService.getAllTasks()) {
            if (task.getCommentCount() > 0) {
                List<CommentEntity> taskComments = commentService.getCommentsByTaskId(task.getId());
                for (CommentEntity comment : taskComments) {
                    String commentContent = comment.getContent().toUpperCase();
                    if (commentContent.contains("BLOCKEDBY")) {
                        String[] commentParts = commentContent.split("BLOCKEDBY");
                        String taskWhichBlocks = commentParts[commentParts.length -1].replaceAll("\\s", "");
                    }
                }
            }
        }
    }
}
