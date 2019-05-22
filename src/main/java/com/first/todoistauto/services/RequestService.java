package com.first.todoistauto.services;

import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

@Service
public class RequestService {

    private static final String TODOIST_API_URL = "https://beta.todoist.com/API/v8/";
    private static final String GET_ALL_TASKS = "tasks";
    private static final String GET_COMMENTS_BY_TASK_ID = "comments?task_id=";
    private static final String GET_LABEL_BY_NAME = "labels";
    private static final String TOKEN = "48ad8824d6e24d55b358c5aafecb5f854ae93f71";

    public String getAllTasks() {
        return sendGetRequest(GET_ALL_TASKS);
    }

    public String getCommentsByTaskId(Long taskId) {
        return sendGetRequest(GET_COMMENTS_BY_TASK_ID + taskId);
    }

    public String getGetLabelByName() {
        return sendGetRequest(GET_LABEL_BY_NAME);
    }

    private String sendGetRequest(String address) {
        StringBuilder response = new StringBuilder();
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) new URL(TODOIST_API_URL + address).openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Authorization", "Bearer " + TOKEN);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            BufferedReader responseStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = responseStream.readLine()) != null) {
                response.append(line);
            }
            responseStream.close();
        } catch (MalformedURLException e) {
            System.err.println("Bad url");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
