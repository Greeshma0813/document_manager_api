package com.gundu.babu.controller;

import com.gundu.babu.entity.FileType;
import com.gundu.babu.repository.FileTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/file-types")
public class FileTypeController {

    @Autowired
    private FileTypeRepository fileTypeRepository;

    // Create new file type
    @PostMapping
    public FileType createFileType(@RequestBody FileType fileType) {
        return fileTypeRepository.save(fileType);
    }

    // Get all file types
    @GetMapping
    public List<FileType> getAllFileTypes() {
        return fileTypeRepository.findAll();
    }
}
