package com.github.spring.player.repository;

import com.github.spring.player.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {

    List<PlayerEntity> findAllByName(String name);

    List<PlayerEntity> findAllBySurname(String surname);

}
