package me.dio.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.products.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
