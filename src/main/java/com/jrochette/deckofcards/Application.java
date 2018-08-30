package com.jrochette.deckofcards;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import com.jrochette.deckofcards.repository.*;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public DeckRepository deckRepository(ApplicationContext ctx) {
    return new InMemoryDeckRepository();
  }
}
