package com.github.spring.player.web;

import com.github.spring.player.model.Player;
import com.github.spring.player.service.PlayerService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("/playerslist")
@SessionAttributes("playerSession")
public class PlayerController {

    private static final String VIEW = "playerslist";
    private static final String ATTRIBUTE_NAME = "players";
    private final PlayerService service;
    private final MessageSource messageSource;

    public PlayerController(PlayerService service, MessageSource messageSource) {
        this.service = service;
        this.messageSource = messageSource;
    }

    @GetMapping(value = "/form")
    public String findPlayers(Model model) {
        model.addAttribute(ATTRIBUTE_NAME, service.findAll());
        return VIEW;
    }

    @PostMapping(value = "/form")
    public String addPlayer(@Valid Player player, BindingResult result, Model model, @ModelAttribute PlayerSession session) {
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

    @ExceptionHandler(Exception.class)
    public String error(Exception exception, Model model, Locale locale) {
        model.addAttribute("exception", exception);
        model.addAttribute("message", messageSource.getMessage("error.message", null, locale));

        return "errors";
    }
}
