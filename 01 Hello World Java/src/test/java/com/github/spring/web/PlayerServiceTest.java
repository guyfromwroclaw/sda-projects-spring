package com.github.spring.web;

import com.github.spring.player.model.Player;
import com.github.spring.player.service.PlayerService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerServiceTest {

    private final PlayerService service = new PlayerService();

    @Test
    public void addThrowExceptionForNull() {
        assertThatThrownBy(() -> service.add(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void removeThrowExceptionForNull() {
        assertThatThrownBy(() -> service.remove(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void addIncreasesSizeOfPlayersList() {
        service.add(new Player("Robert", "Lewy"));
        assertThat(service.findAll()).hasSize(1).containsExactly(new Player("Robert", "Lewy"));
    }

    @Test
    public void removeDecreasesSizeOfPlayersList() {
        service.add(new Player("Robert", "Lewy"));
        service.add(new Player("Kuba", "Błaszczu"));
        service.remove(new Player("Robert", "Lewy"));

        assertThat(service.findAll()).hasSize(1).containsExactly(new Player("Kuba", "Błaszczu"));
    }
}