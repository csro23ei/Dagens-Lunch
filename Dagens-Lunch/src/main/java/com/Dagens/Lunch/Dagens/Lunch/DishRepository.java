package com.Dagens.Lunch.Dagens.Lunch;

import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {
    Dish findByName(String name);
}
