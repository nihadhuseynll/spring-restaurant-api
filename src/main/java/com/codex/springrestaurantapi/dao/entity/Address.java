package com.codex.springrestaurantapi.dao.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {

    @Field(type = FieldType.Keyword)
    String streetNumber;

    @Field(type = FieldType.Text)
    String streetName;

    @Field(type = FieldType.Keyword)
    String unit;

    @Field(type = FieldType.Keyword)
    String city;

    @Field(type = FieldType.Keyword)
    String state;

    @Field(type = FieldType.Keyword)
    String postalCode;

    @Field(type = FieldType.Keyword)
    String country;
}
