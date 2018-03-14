package com.github.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayerController {

    private static final String VIEW = "playerslist";
    private static final String ATTRIBUTE_NAME = "players";
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping(value = "/display")
    public String findPlayers(Model model) {
        model.addAttribute(ATTRIBUTE_NAME, service.findAll());
        return VIEW;
    }

    @PostMapping(value = "/add")
    public String addPlayer(Player player, Model model) {
        service.add(player);
        model.addAttribute(ATTRIBUTE_NAME, service.findAll());
        return VIEW;
    }

    @PostMapping(value = "remove")
    public String removePlayer(Player player, Model model) {
        service.remove(player);
        model.addAttribute(ATTRIBUTE_NAME, service.findAll());
        return VIEW;
    }
}
