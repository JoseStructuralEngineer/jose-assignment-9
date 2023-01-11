package com.coderscampus.joseassignment9.joseassignment9.config;


import com.coderscampus.joseassignment9.joseassignment9.repository.RecipeRepository;
import com.coderscampus.joseassignment9.joseassignment9.service.FileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ConfigData {

    @Bean
    public FileService fileService() throws IOException {

        //Instantiate FileService as if it was a database
        return new FileService("recipes.txt");
    }



}
