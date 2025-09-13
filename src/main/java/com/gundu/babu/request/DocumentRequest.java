package com.gundu.babu.request;

public class DocumentRequest {
    private String name;
    private String fileName;
    private int fileSize;
    private int fileTypeId; // Reference to t_file_type

    // getters & setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getFileTypeId() {
        return fileTypeId;
    }
    public void setFileTypeId(int fileTypeId) {
        this.fileTypeId = fileTypeId;
    }
}

