package com.github.spring.web;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class PlayerControllerTest {
    private final PlayerController controller = new PlayerController();
    private final MockMvc mvc = standaloneSetup(controller).build();

    @Test
    public void display() throws Exception {
        MvcResult result = mvc.perform(get("/display"))
                .andExpect(status().isOk()).andReturn();
        SoftAssertions softly = new SoftAssertions();
        assertThat(result.getModelAndView().getViewName()).isEqualTo("playerslist");
        assertThat(result.getModelAndView().getModel()).containsKey("players");
        softly.assertAll();
    }

    @Test
    public void add() throws Exception {
        MvcResult result = mvc.perform(post("/add").param("name", "name"))
                .andExpect(status().isOk()).andReturn();
        SoftAssertions softly = new SoftAssertions();
        assertThat(result.getModelAndView().getViewName()).isEqualTo("playerslist");
        assertThat(result.getModelAndView().getModel()).containsKey("players");
        softly.assertAll();
    }

    @Test
    public void remove() throws Exception {
        MvcResult result = mvc.perform(post("/remove").param("name", "name"))
                .andExpect(status().isOk()).andReturn();
        SoftAssertions softly = new SoftAssertions();
        assertThat(result.getModelAndView().getViewName()).isEqualTo("playerslist");
        assertThat(result.getModelAndView().getModel()).containsKey("players");
        softly.assertAll();
    }
}