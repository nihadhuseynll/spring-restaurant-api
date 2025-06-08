package com.codex.springrestaurantapi.service.abstraction;

import com.codex.springrestaurantapi.dao.GeoLocation;
import com.codex.springrestaurantapi.dao.entity.Address;

public interface GeoLocationService {
    GeoLocation geoLocate(Address address);
}
