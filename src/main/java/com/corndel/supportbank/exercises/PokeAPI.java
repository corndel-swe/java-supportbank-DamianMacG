package com.corndel.supportbank.exercises;

// import kong.unirest.Unirest;

// import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Pokemon. It uses Java's record syntax to
 * automatically generate a class with getters and utility methods.
 * See this url for more info:
 * https://www.baeldung.com/java-record-keyword
 */
@JsonIgnoreProperties(ignoreUnknown = true)
record Pokemon(Integer id, String name, Integer height, Integer weight) {

  public String summary() {
    return String.format("Meet %s! This Pokémon has an ID of %d. It stands %d decimetres tall and weighs %d hectograms.",
            name.substring(0, 1).toUpperCase() + name.substring(1), id, height, weight);
  }


}

public class PokeAPI {
  /**
   * Get a Pokemon by its name.
   *
   * Makes a GET request to the PokeAPI, and uses Jackson to parse the JSON
   * response into a Pokemon object.
   *
   * @param name The name of the Pokemon to retrieve.
   * @return The Pokemon object.
   */
  public static Pokemon getPokemonByName(String name) throws Exception {
    // TODO: Create the url by appending the name to the base url
    String url = "https://pokeapi.co/api/v2/pokemon/" + name;
    // TODO: Make a GET request to the url


    var response = Unirest
            .get(url)
            .header("Accept", "application/json")
            .asString();

    String json = response.getBody();
//    System.out.println(json);

    // TODO: Parse the response body into a Pokemon object
    // Hint: Use Jackson's ObjectMapper to map the response body to Pokemon.class

    ObjectMapper objectMapper = new ObjectMapper();
    Pokemon pokemon = objectMapper.readValue(json, Pokemon.class);


    return pokemon;
  }

  public static List<Pokemon> getAllPokemons() throws Exception {
    String url = "https://pokeapi.co/api/v2/pokemon?limit=100"; // Adjust limit as needed
    var response = Unirest
            .get(url)
            .header("Accept", "application/json")
            .asString();

    String json = response.getBody();
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode rootNode = objectMapper.readTree(json);
    JsonNode resultsNode = rootNode.get("results"); // Access the "results" array

    List<Pokemon> pokemons = new ArrayList<>();

    // Iterate through the results and extract the names
    for (JsonNode node : resultsNode) {
      String name = node.get("name").asText(); // Get the name of the Pokémon
      Pokemon pokemon = getPokemonByName(name); // Fetch the full Pokémon object
      pokemons.add(pokemon); // Add the Pokémon to the list
    }

    return pokemons;
  }

  /**
   * For debugging purposes..
   */
  public static void main(String[] args) {
    try {
      // Get a specific Pokémon
      Pokemon pokemon = getPokemonByName("pikachu");
      System.out.println(pokemon);
      System.out.println(pokemon.summary()); // Using summary string

      // Get all Pokémon names
      List<Pokemon> allPokemons = getAllPokemons();
      System.out.println("All Pokémon:");
      for (Pokemon name : allPokemons) {
        System.out.println(name);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
