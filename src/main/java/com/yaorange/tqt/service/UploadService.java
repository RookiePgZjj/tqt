package com.yaorange.tqt.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author:zjj
 * @date 2020/3/10 16:22
 * @description:
 */
public interface UploadService {
    String upload(Long status, MultipartFile file);
}
