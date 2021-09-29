package com.sda.fish.store.repositories;

import com.sda.fish.store.entities.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Integer> {

    List<CartEntity> findAllByUser_Username(String username);
}
