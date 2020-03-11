package com.yaorange.tqt.controller;

import com.yaorange.tqt.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author:zjj
 * @date 2020/3/8 13:38
 * @description:
 */
@RestController
@RequestMapping("/api/uploadFiles")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/{status}")
    public ResponseEntity<String> upload(@PathVariable("status") Long status, @RequestParam("file") MultipartFile file) {
        String path = uploadService.upload(status,file);
        if (path != null){
            return ResponseEntity.ok(path);
        }
        return ResponseEntity.badRequest().build();
    }
}
