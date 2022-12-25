package me.dio.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.products.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
