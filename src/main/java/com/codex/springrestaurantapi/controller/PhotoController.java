package com.codex.springrestaurantapi.controller;


import com.codex.springrestaurantapi.dao.entity.Photo;
import com.codex.springrestaurantapi.dto.PhotoDto;
import com.codex.springrestaurantapi.mapper.PhotoMapper;
import com.codex.springrestaurantapi.service.abstraction.PhotoService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/photo")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PhotoController {

    PhotoService photoService;
    PhotoMapper photoMapper;

    @PostMapping
    public PhotoDto uploadPhoto(@RequestParam MultipartFile file) {
        Photo savedPhoto = photoService.uploadPhoto(file);
        return photoMapper.toPhotoDto(savedPhoto);
    }

    @GetMapping(path = "/id:.+")
    public ResponseEntity<Resource> getPhoto(@PathVariable String id){
        return photoService.getPhotoAsResource(id).map( photo ->
                ResponseEntity.ok()
                        .contentType(
                                MediaTypeFactory.getMediaType(photo)
                                        .orElse(MediaType.APPLICATION_OCTET_STREAM)
                        )
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                        .body(photo)
        ).orElse(ResponseEntity.notFound().build());
    }
}
