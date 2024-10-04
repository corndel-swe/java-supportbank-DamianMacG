package com.corndel.supportbank.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class NewsAPIService {
    private final String apiKey;
    private final ObjectMapper objectMapper;

    public NewsAPIService() {
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("NEWS_KEY");
        this.objectMapper = new ObjectMapper();
    }

    public void fetchNewsByAuthor(String authorName) throws JsonProcessingException {
        // Using the keyword as a placeholder in the URL
        String url = String.format("https://newsapi.org/v2/everything?q=keyword&apiKey=%s", apiKey);

        var response = Unirest
                .get(url)
                .header("Accept", "application/json")
                .asString();

        if (response.getStatus() == 200) {
            String json = response.getBody();
            JsonNode ratesNode = objectMapper.readTree(json);

            // Fetching all articles
            JsonNode articles = ratesNode.get("articles");
            if (articles != null && articles.size() > 0) {

                Set<String> matchingAuthors = new HashSet<>();


                // Filter articles based on the author name
                for (int i = 0; i < articles.size(); i++) {
                    JsonNode article = articles.get(i);
                    String author = article.has("author") ? article.get("author").asText() : "Unknown Author";


                    if (author.toLowerCase().contains(authorName.toLowerCase())) {
                        matchingAuthors.add(author); // Store unique authors
                        // Print article details
                        System.out.println("Author: " + author);
                        System.out.println("Article: " + article.toPrettyString());
                    }
                }

//                 Print all matching authors found
                if (!matchingAuthors.isEmpty()) {
                    System.out.println("Matching Authors:");
                    for (String uniqueAuthor : matchingAuthors) {
                        System.out.println(uniqueAuthor);
                    }
                } else {
                    System.out.println("No articles found for the given author.");
                }
            } else {
                System.out.println("No articles found.");
            }
        } else {
            System.out.println("Error fetching news: " + response.getStatus() + " - " + response.getStatusText());
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        Scanner scanner = new Scanner(System.in); // Create a scanner for user input
        NewsAPIService newsService = new NewsAPIService();

        System.out.print("Enter the author's name or part of the name to search for articles: ");
        String authorName = scanner.nextLine(); // Read user input

        newsService.fetchNewsByAuthor(authorName); // Fetch news by the author name provided by the user

        scanner.close(); // Close the scanner
    }
}