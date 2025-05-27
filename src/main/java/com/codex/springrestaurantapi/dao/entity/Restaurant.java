package com.codex.springrestaurantapi.dao.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "restaurants")
public class Restaurant {

    @Id
    String id;

    @Field(type = FieldType.Text)
    String name;

    @Field(type = FieldType.Text)
    String cuisineType;

    @Field(type = FieldType.Keyword)
    String contactInformation;

    @Field(type = FieldType.Float)
    Float averageRating;

    @GeoPointField
    GeoPoint geoLocation;

    @Field(type = FieldType.Nested)
    Address address;

    @Field(type = FieldType.Nested)
    OperatingHours operatingHours;

    @Field(type = FieldType.Nested)
    List<Photo> photos = new ArrayList<>();

    @Field(type = FieldType.Nested)
    List<Review> reviews = new ArrayList<>();

    @Field(type = FieldType.Nested)
    User createdBy;
}
