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
public class User {

    @Field(type = FieldType.Keyword)
    String id;

    @Field(type = FieldType.Text)
    String username;

    @Field(type = FieldType.Text)
    String givenName;

    @Field(type = FieldType.Text)
    String familyName;
}