package com.github.spring.team.repository;

import com.github.spring.team.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {

    List<TeamEntity> findAllByName(String name);
}
