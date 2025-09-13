package com.gundu.babu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Long id;

    @Column(name = "f_name", nullable = false)
    private String name;

    @Column(name = "f_file_name", nullable = false)
    private String fileName;

    @Column(name = "f_file_size")
    private int fileSize;

    // foreign key to t_file_type
    @ManyToOne
    @JoinColumn(name = "f_file_type", referencedColumnName = "id")
    private FileType fileType;

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }
}

