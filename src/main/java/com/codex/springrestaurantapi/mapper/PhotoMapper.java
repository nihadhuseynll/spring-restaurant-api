package com.codex.springrestaurantapi.mapper;

import com.codex.springrestaurantapi.dao.entity.Photo;
import com.codex.springrestaurantapi.dto.PhotoDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {

    PhotoDto toPhotoDto(Photo photo);
}
