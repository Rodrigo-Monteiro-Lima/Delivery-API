package me.dio.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.products.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
