package me.dio.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.products.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
