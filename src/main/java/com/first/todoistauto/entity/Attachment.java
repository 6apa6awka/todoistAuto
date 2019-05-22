package com.first.todoistauto.entity;

import com.google.gson.annotations.SerializedName;

public class Attachment {

    @SerializedName("resource_type")
    private String resourceType;

    @SerializedName("file_url")
    private String fileUrl;

    @SerializedName("file_type")
    private String fileType;

    @SerializedName("file_name")
    private String fileName;

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
