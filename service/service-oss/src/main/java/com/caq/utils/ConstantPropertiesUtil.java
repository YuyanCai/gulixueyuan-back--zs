package com.caq.utils;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
/**
 * 当项目已启动，spring接口，spring加载之后，执行接口一个方法
 * 读取配置文件内容后，在通过执行接口里的一个方法，从而让外面能使用
 */
public class ConstantPropertiesUtil implements InitializingBean {
    //读取配置文件内容
    @Value("${OSS.endpoint}")
    private String endpoint;

    @Value("${OSS.accessKeyId}")
    private String accessKeyId;

    @Value("${OSS.accessKeySecret}")
    private String accessKeySecret;

    @Value("${OSS.bucketName}")
    private String bucketName;

    //定义公开静态常量
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;


    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = accessKeyId;
        ACCESS_KEY_SECRET = accessKeySecret;
        BUCKET_NAME = bucketName;
    }
}
