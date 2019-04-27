package com.taoqi.file.repository;

import com.taoqi.file.domain.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @作者：刘时明
 * @时间：2019/4/6-12:27
 * @说明：
 */
public interface IImageRepository extends MongoRepository<Image, String>
{
}
