package com.taoqi.file.service;

import com.taoqi.file.domain.Image;
import com.taoqi.file.exception.FileServerException;
import com.taoqi.file.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @作者：刘时明
 * @时间：2019/4/6-12:31
 * @说明：
 */
@Service
public class ImageServiceImpl
{
    @Autowired
    private IImageRepository imageRepository;

    @Value("${fileServer.host}")
    private String serverHost;

    private static final Set<String> set;

    static
    {
        set = new HashSet<>();
        set.add(".jpg");
        set.add(".jpeg");
        set.add(".png");
        set.add(".gif");
    }

    public String uploadImage(MultipartFile file) throws FileServerException
    {
        if (!file.isEmpty())
        {
            try
            {
                //源文件名
                String fileName = file.getOriginalFilename();
                //源文件后缀
                String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
                //数据库文件Id,且以id为新的文件名
                String fileId = UUID.randomUUID() + "";
                if (file.getSize() > 1000 * 1024)
                {
                    throw new FileServerException("上传失败,图片大于10MB");
                }
                if (!set.contains(fileSuffix))
                {
                    throw new FileServerException("上传失败，不支持该图片格式");
                }
                Image image = new Image();
                image.setName(fileId);
                image.setSize(file.getSize());
                image.setContentType(file.getContentType());
                image.setContent(file.getBytes());
                Image newImage = imageRepository.save(image);
                return serverHost + "/image/" + newImage.getId();
            } catch (Exception e)
            {
                throw new FileServerException("上传失败，" + e.getMessage());
            }
        } else
        {
            throw new FileServerException("文件不存在");
        }
    }

    public Image getImageById(String id)
    {
        return imageRepository.findById(id).get();
    }

    public List<Image> get()
    {
        return imageRepository.findAll();
    }
}
