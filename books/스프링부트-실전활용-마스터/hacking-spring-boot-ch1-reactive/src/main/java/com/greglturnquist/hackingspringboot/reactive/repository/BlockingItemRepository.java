package com.greglturnquist.hackingspringboot.reactive.repository;

import com.greglturnquist.hackingspringboot.reactive.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface BlockingItemRepository extends CrudRepository<Item, String> {
}
