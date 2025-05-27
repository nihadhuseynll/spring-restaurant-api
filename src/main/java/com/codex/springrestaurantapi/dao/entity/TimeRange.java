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
public class TimeRange {

    @Field(type = FieldType.Keyword)
    String openTime;

    @Field(type = FieldType.Keyword)
    String closeTime;
}
