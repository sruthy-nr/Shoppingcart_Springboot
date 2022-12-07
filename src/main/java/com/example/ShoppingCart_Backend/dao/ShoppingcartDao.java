package com.example.ShoppingCart_Backend.dao;

import com.example.ShoppingCart_Backend.model.Shoppingcart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingcartDao extends CrudRepository<Shoppingcart,Integer> {

    @Query(value = "SELECT `id`, `category`, `description`, `image`, `name`, `price` FROM `shoppingcart` WHERE `name` LIKE %:name%",nativeQuery = true)
    List<Shoppingcart> searchProduct(@Param("name") String name);
}


