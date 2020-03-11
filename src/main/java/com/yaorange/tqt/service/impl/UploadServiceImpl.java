package com.yaorange.tqt.service.impl;

import com.yaorange.tqt.config.UploadProperties;
import com.yaorange.tqt.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author:zjj
 * @date 2020/3/10 16:23
 * @description:
 */
@Service
@Slf4j
public class UploadServiceImpl implements UploadService {
    private static final Long IMAGE_TYPE = 1L;
    private static final Long MUSIC_TYPE = 2L;

    @Autowired
    private UploadProperties uploadProperties;

    @Override
    public String upload(Long status, MultipartFile file) {
        if (!file.isEmpty()) {
            File dir = null;
            if (IMAGE_TYPE.equals(status)) {
                dir = new File(uploadProperties.getImageRoot());
                if (!dir.exists()) {
                    dir.mkdirs();
                }
            } else if (MUSIC_TYPE.equals(status)) {
                dir = new File(uploadProperties.getMusicRoot());
                if (!dir.exists()) {
                    dir.mkdirs();
                }
            }

            String originalFilename = file.getOriginalFilename();
            String[] split = originalFilename.split("\\.");
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String fileName = uuid + "." + split[split.length - 1];
            File uploadFile = new File(dir.getAbsolutePath() + File.separator + fileName);
            try {
                file.transferTo(uploadFile);

                if (IMAGE_TYPE.equals(status)) {
                    log.info("文件名={}",uploadProperties.getPrefixImage() + fileName);
                    return uploadProperties.getPrefixImage() + fileName;
                }else {
                    log.info("文件名={}",uploadProperties.getPrefixMusic() + fileName);
                    return uploadProperties.getPrefixMusic() + fileName;
                }
            } catch (IOException e) {
                e.printStackTrace();

                log.info("文件上传异常");
            }
        }
        return null;
    }

}
