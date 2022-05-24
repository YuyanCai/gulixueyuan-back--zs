package com.caq.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.caq.service.OssService;
import com.caq.utils.ConstantPropertiesUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ConstantPropertiesUtil.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;


        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
            InputStream inputStream = file.getInputStream();

            //获取文件名称
            String filename = file.getOriginalFilename();

            //1.在文件名称上添加一个随机唯一值
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");//将uuid的-替换掉

            filename = uuid + filename;

            //2.把文件按日期分类
            //获取当前日期时间
            String datePath = new DateTime().toString("yyyy/MM/dd");
            //拼接
            filename = datePath + "/" + filename;


            // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
            //第一个参数：bucket名称
            // 第二个参数：上传到oss的文件和路径名称  aa/bb/cc.jpg
            // 第三个参数：上传文件的输入流
            ossClient.putObject(bucketName, filename, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            //返回连接地址
            String url = "https://" + bucketName + "." + endpoint + "/" + filename;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
