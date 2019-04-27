package com.taoqi.file.controller;

import com.taoqi.file.domain.Image;
import com.taoqi.file.exception.FileServerException;
import com.taoqi.file.service.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/6-13:15
 * @说明：
 */
@RestController
@RequestMapping(value = "/image")
public class ImageController
{
    // http://localhost:10086/image/uploadImage
    @Autowired
    private ImageServiceImpl imageService;

    @PostMapping(value = "/uploadImage")
    public Map<String, Object> uploadImage(@RequestParam("file") MultipartFile file) throws FileServerException
    {
        Map<String, Object> map = new HashMap<>();
        try
        {
            map.put("msg", "http://"+imageService.uploadImage(file));
            map.put("code", 200);
        } catch (FileServerException e)
        {
            map.put("msg", e.getMessage());
            map.put("code", 500);
        }
        return map;
    }


    @GetMapping(value = "/{imageId}")
    public ResponseEntity<Object> getImageById(@PathVariable String imageId)
    {
        Image image = imageService.getImageById(imageId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + image.getName() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, image.getContentType())
                .header(HttpHeaders.CONTENT_LENGTH, image.getSize() + "")
                .header("Connection", "close")
                .body(image.getContent());
    }

    @GetMapping("get")
    public ResponseEntity<Object> get()
    {
        List<Image> list=imageService.get();
        List<String> temp=new ArrayList<>();
        list.stream().forEach(t->temp.add(t.getId()));
        return ResponseEntity.ok().body(temp);
    }
}
