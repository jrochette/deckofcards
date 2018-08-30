package com.jrochette.deckofcards.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DeckControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void createDeckShouldReturnADeck() throws Exception {
    MvcResult result =
        mvc.perform(MockMvcRequestBuilders.post("/decks").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn();

    System.out.println(result.getResponse().getContentAsString().toString());
  }
}
