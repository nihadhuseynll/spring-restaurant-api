package com.codex.springrestaurantapi.service.abstraction;

import com.codex.springrestaurantapi.dao.entity.Restaurant;
import com.codex.springrestaurantapi.dto.RestaurantCreateAndUpdateRequest;

public interface RestaurantService {
    Restaurant createRestaurant(RestaurantCreateAndUpdateRequest restaurantCreateAndUpdateRequest);
}
