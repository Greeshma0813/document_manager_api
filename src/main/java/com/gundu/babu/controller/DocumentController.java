package com.gundu.babu.controller;

import com.gundu.babu.entity.Document;
import com.gundu.babu.entity.FileType;
import com.gundu.babu.repository.DocumentRepository;
import com.gundu.babu.repository.FileTypeRepository;
import com.gundu.babu.request.DocumentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private FileTypeRepository fileTypeRepository;

    // Create new document (with fileTypeId reference)
    @PostMapping
    public Document createDocument(@RequestBody DocumentRequest request) {
        FileType fileType = fileTypeRepository.findById(request.getFileTypeId())
                .orElseThrow(() -> new RuntimeException("FileType not found"));

        Document document = new Document();
        document.setName(request.getName());
        document.setFileName(request.getFileName());
        document.setFileSize(request.getFileSize());
        document.setFileType(fileType);

        return documentRepository.save(document);
    }

    // Get all documents
    @GetMapping
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }
}

