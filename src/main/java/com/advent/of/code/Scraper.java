package com.advent.of.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

/**
 * A class to scrape the input for the Advent of Code 2024 challenge
 */
public final class Scraper {
    private final int dayOfTheMonth;
    private String path;
    private String input;

    /**
     * Constructor for the Scraper class
     * The default constructor will save the input for today
     */
    public Scraper() {
        Calendar cal = Calendar.getInstance();
        this.dayOfTheMonth = cal.get(Calendar.DAY_OF_MONTH);
        this.saveInput(this.dayOfTheMonth); // Save input for today
    }

    /**
     * Constructor for the Scraper class
     * @param dayOfTheMonth The specific day of the month
     */
    public Scraper(int dayOfTheMonth) {
        this.dayOfTheMonth = dayOfTheMonth;
        this.saveInput(this.dayOfTheMonth); // Save input for a specific day
    }

    public String getInput() {
        return this.input;
    }

    public String getPath() {
        return this.path;
    }

    /**
     * Save the input for a specific day
     * @param dayOfTheMonth The specific day of the month
     * @return The path to the saved input file
     */
    private void saveInput(int dayOfTheMonth) {
        try {
            this.path = "src\\main\\resources\\input\\" + dayOfTheMonth + ".txt";
            if (new File(this.path).exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();

                    while (line != null) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                    }
                    this.input = sb.toString();
                }
            } else {
                Dotenv dotenv = Dotenv.configure().load();

                String url = "https://adventofcode.com/2024/day/" + dayOfTheMonth + "/input";

                Map<String, String> cookies = new HashMap<>();
                cookies.put("session", dotenv.get("SESSION_COOKIE"));

                Connection.Response doc = Jsoup.connect(url)
                        .cookies(cookies)
                        .method(Connection.Method.GET)
                        .execute();

                if (doc.statusCode() != 200) {
                    throw new IOException(doc.statusCode() + " (" + doc.body() + ")");
                }

                this.input = doc.body();
                
                try (FileWriter myWriter = new FileWriter(this.path)) {
                    myWriter.write(this.input);
                }
                System.out.println("Successfully saved input for day " + dayOfTheMonth);
            }
        } catch (DotenvException e) {
            System.err.println("Error while loading .env file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error while saving input: " + e.getMessage());
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Scraper temp = new Scraper();
    }
}
