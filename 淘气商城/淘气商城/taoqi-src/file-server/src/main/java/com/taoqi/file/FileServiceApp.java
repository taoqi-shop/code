package com.taoqi.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @作者：刘时明
 * @时间：2019/4/6-12:23
 * @说明：
 */
@SpringBootApplication
public class FileServiceApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(FileServiceApp.class);
    }

    /**
     * 文件上传配置
     *
     * @return
     */
//    @Bean
//    public MultipartConfigElement multipartConfigElement()
//    {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //文件最大
//        factory.setMaxFileSize(DataSize.parse("10MB"));
//        /// 设置总上传数据总大小
//        factory.setMaxFileSize(DataSize.parse("100MB"));
//        return factory.createMultipartConfig();
//    }
}
