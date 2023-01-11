package com.coderscampus.joseassignment9.joseassignment9.repository;

import com.coderscampus.joseassignment9.joseassignment9.domain.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository implements ObjectRepository<Recipe> {

    public List<Recipe> recipeArrayList = new ArrayList<>();


    public List<Recipe> findAll(String file) throws IOException {
        recipeArrayList = new ArrayList<>();
        Reader in = new FileReader(file);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withDelimiter(',')
                .withIgnoreSurroundingSpaces()
                .withHeader()
                .withSkipHeaderRecord()
                .withEscape('\\')
                .parse(in);

        for (CSVRecord record : records) {

            int cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
            boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
            boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
            String instructions = record.get("Instructions");
            double preparationMinutes = Double.parseDouble(record.get("Preparation Minutes"));
            double pricePerServing = Double.parseDouble(record.get("Price Per Serving"));
            int readyInMinutes = Integer.parseInt(record.get("Ready In Minutes"));
            int servings = Integer.parseInt(record.get("Servings"));
            double spoonaculatScore = Double.parseDouble(record.get("Spoonacular Score"));
            String title = record.get("Title");
            boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
            boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));

            Recipe recipe = new Recipe(cookingMinutes,dairyFree,
                    glutenFree,instructions,
                    preparationMinutes,
                    pricePerServing,
                    readyInMinutes,
                    servings,
                    spoonaculatScore,
                    title,
                    vegan,
                    vegetarian);

            recipeArrayList.add(recipe);
        }
        return recipeArrayList;
    }


    @Override
    public void store(Recipe recipe) {
        recipeArrayList.add(recipe);
    }

    @Override
    public Recipe retrieve(int id) {
        return null;
    }

    @Override
    public Recipe search(String name) {
        return null;
    }

    @Override
    public Recipe delete(int id) {
        return null;
    }
}
