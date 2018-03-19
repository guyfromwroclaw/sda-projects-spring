package com.github.spring.player.service;

import com.github.spring.player.entity.PlayerEntity;
import com.github.spring.player.model.Player;
import com.github.spring.player.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

@Service
public class PlayerService {
    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> findAll() {
        return toPlayersList(repository.findAll());
    }

    public void add(Player player) {
        argumentValidation(player);
        repository.save(toEntity(player));
    }

    public void remove(Player player) {
        argumentValidation(player);
        repository.delete(toEntity(player));
    }

    private void argumentValidation(Player player) {
        checkArgument(player.getName() != null && !player.getName().equals(""), "Name can not be null or empty");
        checkArgument(player.getSurname() != null && !player.getSurname().equals(""), "Surname can not be null or empty");
    }

    private PlayerEntity toEntity(Player player) {
        return new PlayerEntity(player.getName(), player.getSurname());
    }

    private Player toPlayer(PlayerEntity entity) {
        return new Player(entity.getName(), entity.getSurname());
    }

    private List<Player> toPlayersList(List<PlayerEntity> entities) {
        return entities.stream().map(this::toPlayer).collect(Collectors.toList());
    }
}
