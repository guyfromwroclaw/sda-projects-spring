package com.github.spring.player.web;

import com.github.spring.player.model.Player;

public class PlayerSession {
    private int counter;
    private Player recentPlayer;

    public PlayerSession() {
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Player getRecentPlayer() {
        return recentPlayer;
    }

    public void setRecentPlayer(Player recentPlayer) {
        this.recentPlayer = recentPlayer;
    }
}
