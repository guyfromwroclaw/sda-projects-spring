package com.github.spring.player.web;

import com.github.spring.player.model.Player;
import com.github.spring.player.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/playerslist")
@SessionAttributes("playerSession")
public class PlayerController {

    private static final String VIEW = "playerslist";
    private static final String ATTRIBUTE_NAME = "players";
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping(value = "/form")
    public String findPlayers(Model model) {
        model.addAttribute(ATTRIBUTE_NAME, service.findAll());
        return VIEW;
    }

    @PostMapping(value = "/form")
    public String addPlayer(@Valid Player player, BindingResult result, Model model, @ModelAttribute PlayerSession session
    ) {
        if (result.hasErrors()) {
            model.addAttribute(ATTRIBUTE_NAME, service.findAll());
            return VIEW;
        }

        service.add(player);
        session.setCounter(session.getCounter() + 1);
        session.setRecentPlayer(player);
        model.addAttribute(ATTRIBUTE_NAME, service.findAll());
        return "redirect:/" + VIEW + "/form";
    }

    @PostMapping(value = "/remove")
    public String removePlayer(@Valid Player player, BindingResult result, Model model) {
        service.remove(player);
        model.addAttribute(ATTRIBUTE_NAME, service.findAll());
        return VIEW;
    }

    @ModelAttribute
    public Player defaultPlayer() {
        return new Player("name", "surname");
    }

    @ModelAttribute
    public PlayerSession session() {
        return new PlayerSession();
    }
}
