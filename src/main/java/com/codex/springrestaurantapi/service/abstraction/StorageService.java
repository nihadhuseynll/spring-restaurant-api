package com.codex.springrestaurantapi.service.abstraction;

import com.codex.springrestaurantapi.dao.entity.Restaurant;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface StorageService {
    String store(MultipartFile file, String fileName);
    Optional<Resource> loadAsResource(String id);
}
