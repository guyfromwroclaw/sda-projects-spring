package com.github.spring.web;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

@Service
public class PlayerService {

    private List<String> players = new ArrayList<>();

    public List<String> findAll() {
        return players;
    }

    public void add(String name, String surname) {
        argumentValidation(name, surname);
        players.add(name + " " + surname);
    }

    public void remove(String name, String surname) {
        argumentValidation(name, surname);
        players.remove(name + " " + surname);
    }

    private void argumentValidation(String name, String surname) {
        checkArgument(name != null && !name.equals(""), "Name can not be null or empty");
        checkArgument(surname != null && !surname.equals(""), "Surname can not be null or empty");
    }
}
