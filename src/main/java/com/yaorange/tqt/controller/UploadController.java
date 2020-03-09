package com.yaorange.tqt.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UploadController {

    private static final String FILE_ROOT = "E:\\tqtUpload";
    private static final String MUSIC_ROOT = "musicFiles";
    private static final String IMAGE_ROOT = "imageFiles";
    private static final Long IMAGE_TYPE = 1L;
    private static final Long MUSIC_TYPE = 2L;

    @PostMapping("/{status}")
    public ResponseEntity<String> upload(@PathVariable("status") Long status, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            File dir = null;
            if (IMAGE_TYPE.equals(status)) {
                dir = new File(FILE_ROOT + File.separator + IMAGE_ROOT);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
            } else if (MUSIC_TYPE.equals(status)) {
                dir = new File(FILE_ROOT + File.separator + MUSIC_ROOT);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
            }

            String originalFilename = file.getOriginalFilename();
            String[] split = originalFilename.split("\\.");
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String fileName = uuid + "." + split[split.length - 1];
            File musicFile = new File(dir.getAbsolutePath() + File.separator + fileName);
            try {
                file.transferTo(musicFile);
                return ResponseEntity.ok(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                log.info("录音上传失败");
                return ResponseEntity.badRequest().build();
            }

        }
        return ResponseEntity.badRequest().build();
    }
}
