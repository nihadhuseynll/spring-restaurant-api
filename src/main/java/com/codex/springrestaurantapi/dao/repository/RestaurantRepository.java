package com.codex.springrestaurantapi.dao.repository;

import com.codex.springrestaurantapi.dao.entity.Restaurant;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends ElasticsearchRepository<Restaurant, String> {
    // TODO: Custom Queries
}
