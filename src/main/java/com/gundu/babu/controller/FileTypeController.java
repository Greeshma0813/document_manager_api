package com.gundu.babu.controller;

import com.gundu.babu.entity.FileType;
import com.gundu.babu.repository.FileTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFileType(@PathVariable int id) {
        if (!fileTypeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        fileTypeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FileType> updateFileType(@PathVariable int id, @RequestBody FileType updatedType) {
        return fileTypeRepository.findById(id)
                .map(fileType -> {
                    fileType.setTypeName(updatedType.getTypeName());
                    FileType saved = fileTypeRepository.save(fileType);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
