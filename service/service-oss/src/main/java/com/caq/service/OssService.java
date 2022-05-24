package com.caq.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    //上传头像
    String uploadFileAvatar(MultipartFile file);
}
