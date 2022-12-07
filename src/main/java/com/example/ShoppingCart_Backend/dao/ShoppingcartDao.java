package com.example.ShoppingCart_Backend.dao;

import com.example.ShoppingCart_Backend.model.Shoppingcart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingcartDao extends CrudRepository<Shoppingcart,Integer> {
}
