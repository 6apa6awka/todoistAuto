package com.first.todoistauto.services;

import com.first.todoistauto.entity.CommentEntity;
import com.first.todoistauto.entity.TaskEntity;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParseService<T> {

    public ParseService() {
    }

    public List<TaskEntity> parseTasksResponse (String response) {
        List<TaskEntity> taskEntityList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            Gson gson = new Gson();
            for (int i = 0; i < jsonArray.length(); i++) {
                TaskEntity task = gson.fromJson(jsonArray.getJSONObject(i).toString(), TaskEntity.class);
                taskEntityList.add(task);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return taskEntityList;
    }

    public List<T> parseResponse (String response, Class<T> tClass) {
        List<T> entityList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            Gson gson = new Gson();
            for (int i = 0; i < jsonArray.length(); i++) {
                T entity = gson.fromJson(jsonArray.getJSONObject(i).toString(), tClass);
                entityList.add(entity);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return entityList;
    }
}
