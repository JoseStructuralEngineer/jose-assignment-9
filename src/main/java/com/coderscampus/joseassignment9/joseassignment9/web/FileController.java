package com.coderscampus.joseassignment9.joseassignment9.web;

import com.coderscampus.joseassignment9.joseassignment9.domain.Recipe;
import com.coderscampus.joseassignment9.joseassignment9.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FileController {

    @Autowired
    public FileService fileService;

    @GetMapping("/")
    public List<Recipe> readLines () throws IOException {
        return fileService.readAllRecipes();
    }

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeData () throws IOException {
        return fileService.getGlutenFree();
    }

    @GetMapping("/vegan")
    public List<Recipe> getVeganData () throws IOException {
        return fileService.getVegan();
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeData () throws IOException {
        return fileService.getVeganAndGlutenFree();
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarian () throws IOException {
        return fileService.getVegetarian();
    }

    @GetMapping("/all-recipes")
    public List<Recipe> readAllRecipies () throws IOException {
        return fileService.readAllRecipes();
    }

}
