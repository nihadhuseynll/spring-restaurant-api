package com.codex.springrestaurantapi.dto;

import com.codex.springrestaurantapi.dao.entity.Address;
import com.codex.springrestaurantapi.dao.entity.OperatingHours;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantCreateAndUpdateRequest {

    String name;
    String cuisineType;
    String contactInformation;
    Address address;
    OperatingHours operatingHours;
    List<String> photoIds;
}
