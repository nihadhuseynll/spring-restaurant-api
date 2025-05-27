package com.codex.springrestaurantapi.dao.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.sql.Time;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperatingHours {

    @Field(type = FieldType.Nested)
    TimeRange monday;

    @Field(type = FieldType.Nested)
    TimeRange tuesday;

    @Field(type = FieldType.Nested)
    TimeRange wednesday;

    @Field(type = FieldType.Nested)
    TimeRange thursday;

    @Field(type = FieldType.Nested)
    TimeRange friday;

    @Field(type = FieldType.Nested)
    TimeRange saturday;

    @Field(type = FieldType.Nested)
    TimeRange sunday;
}
