package com.codex.springrestaurantapi.service.concrete;

import com.codex.springrestaurantapi.dao.GeoLocation;
import com.codex.springrestaurantapi.dao.entity.Photo;
import com.codex.springrestaurantapi.dao.entity.Restaurant;
import com.codex.springrestaurantapi.dao.repository.RestaurantRepository;
import com.codex.springrestaurantapi.dto.RestaurantCreateAndUpdateRequest;
import com.codex.springrestaurantapi.service.abstraction.GeoLocationService;
import com.codex.springrestaurantapi.service.abstraction.RestaurantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestaurantServiceImpl implements RestaurantService {

    RestaurantRepository restaurantRepository;
    GeoLocationService geoLocationService;

    @Override
    public Restaurant createRestaurant(RestaurantCreateAndUpdateRequest restaurantCreateAndUpdateRequest) {
        GeoLocation geoLocation = geoLocationService.geoLocate(restaurantCreateAndUpdateRequest.getAddress());
        GeoPoint geoPoint = new GeoPoint(geoLocation.getLatitude(), geoLocation.getLongitude());

        List<String> photoIds = restaurantCreateAndUpdateRequest.getPhotoIds();
        List<Photo> photos = photoIds.stream().map(photoUrl -> Photo.builder()
                .url(photoUrl)
                .uploadDate(LocalDateTime.now())
                .build()).toList();

        Restaurant restaurant = Restaurant.builder()
                .name(restaurantCreateAndUpdateRequest.getName())
                .cuisineType(restaurantCreateAndUpdateRequest.getCuisineType())
                .contactInformation(restaurantCreateAndUpdateRequest.getContactInformation())
                .address(restaurantCreateAndUpdateRequest.getAddress())
                .geoLocation(geoPoint)
                .operatingHours(restaurantCreateAndUpdateRequest.getOperatingHours())
                .averageRating(0f)
                .photos(photos)
                .build();

        return restaurantRepository.save(restaurant);
    }
}
