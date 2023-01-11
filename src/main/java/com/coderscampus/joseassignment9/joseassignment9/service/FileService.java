package com.coderscampus.joseassignment9.joseassignment9.service;

import com.coderscampus.joseassignment9.joseassignment9.domain.Recipe;
import com.coderscampus.joseassignment9.joseassignment9.repository.RecipeRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class FileService {

   @Autowired
   private RecipeRepository recipeRepository;
    private final String fileName;

    public FileService(String fileName)  {
        this.fileName = fileName;
    }

    public List<Recipe> readAllRecipes () throws IOException {
        return recipeRepository.findAll(fileName);
    }

    public List<Recipe> getGlutenFree () throws IOException {
        if(recipeRepository.recipeArrayList.size()==0){
            readAllRecipes ();
        }

        List<Recipe> recipeArrayList = recipeRepository.recipeArrayList;
        return recipeArrayList.stream().filter(e -> e.getGlutenFree().equals(true)).collect(Collectors.toList());
    }

    public List<Recipe> getVegan () throws IOException {

        if(recipeRepository.recipeArrayList.size()==0){
            readAllRecipes ();
        }

        List<Recipe> recipeArrayList = recipeRepository.recipeArrayList;
        //Since we have vegan and gluten free I added this filter
        return recipeArrayList.stream().filter(e -> e.getVegan().equals(true)).collect(Collectors.toList());
    }

    public List<Recipe> getVeganAndGlutenFree () throws IOException {
        if(recipeRepository.recipeArrayList.size()==0){
            readAllRecipes ();
        }
        List<Recipe> recipeArrayList = recipeRepository.recipeArrayList;
        return recipeArrayList.stream().filter(e -> e.getGlutenFree().equals(true) && e.getVegan().equals(true)).collect(Collectors.toList());
    }

    public List<Recipe> getVegetarian () throws IOException {
        if(recipeRepository.recipeArrayList.size()==0){
            readAllRecipes ();
        }
        List<Recipe> recipeArrayList = recipeRepository.recipeArrayList;
        return recipeArrayList.stream().filter(e -> e.getVegetarian().equals(true)).collect(Collectors.toList());
    }
}
