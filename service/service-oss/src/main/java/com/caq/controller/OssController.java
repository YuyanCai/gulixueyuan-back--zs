package com.caq.controller;

import com.caq.commonutils.R;
import com.caq.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduOss/fileOss")
//@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    //上传头像
    @PostMapping("upload")
    public R uploadOssFile(MultipartFile file) {
        //获取上传文件 MultipartFile
        String url = ossService.uploadFileAvatar(file);
        return R.ok().data("url", url);
    }

}
