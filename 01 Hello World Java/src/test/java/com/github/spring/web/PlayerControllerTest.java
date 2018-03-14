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
    private static final String VIEW = "playerslist";
    private static final String MODEL_KEY = "players";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_SURNAME = "surname";

    @Test
    public void display() throws Exception {
        MvcResult result = mvc.perform(get("/display"))
                .andExpect(status().isOk()).andReturn();

        assertModelandViewName(result, VIEW, MODEL_KEY);
    }

    @Test
    public void add() throws Exception {
        MvcResult result = mvc.perform(post("/add").
                param("name", PARAM_NAME).
                param("surname", PARAM_SURNAME))
                .andExpect(status().isOk()).andReturn();

        assertModelandViewName(result, VIEW, MODEL_KEY);
    }

    @Test
    public void remove() throws Exception {
        MvcResult result = mvc.perform(post("/remove")
                .param("name", PARAM_NAME)
                .param("surname", PARAM_SURNAME))
                .andExpect(status().isOk()).andReturn();

        assertModelandViewName(result, VIEW, MODEL_KEY);
    }

    private void assertModelandViewName(MvcResult result, String view, String modelKey) {
        SoftAssertions softly = new SoftAssertions();
        assertThat(result.getModelAndView().getViewName()).isEqualTo(view);
        assertThat(result.getModelAndView().getModel()).containsKey(modelKey);
        softly.assertAll();
    }
}