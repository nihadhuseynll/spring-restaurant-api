package com.codex.springrestaurantapi.dao;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GeoLocation {

    Double latitude;
    Double longitude;
}
