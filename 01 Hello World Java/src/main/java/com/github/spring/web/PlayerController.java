package com.github.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayerController {

    private List<String> playersList = new ArrayList<>();

    @GetMapping(value = "/display")
    public String findPlayers(Model model) {
        model.addAttribute("players", playersList);
        return "playerslist";
    }

    @PostMapping(value = "/add")
    public String addPlayer(@RequestParam String name, Model model) {
        playersList.add(name);
        model.addAttribute("players", playersList);
        return "playerslist";
    }

    @PostMapping(value = "remove")
    public String removePlayer(@RequestParam String name, Model model) {
        playersList.remove(name);
        model.addAttribute("players", playersList);
        return "playerslist";
    }
}
