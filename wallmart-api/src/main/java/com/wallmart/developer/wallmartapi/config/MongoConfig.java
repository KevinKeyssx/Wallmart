package com.wallmart.developer.wallmartapi.config;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wallmart.developer.wallmartapi.document.ProductDocument;
import com.wallmart.developer.wallmartapi.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Kevin Candia
 * @date 06-03-2022
 */
@EnableMongoRepositories(basePackageClasses = IProductRepository.class)
@Configuration
public class MongoConfig {

    @Value("${data}")
    private String data;

    @Bean
    CommandLineRunner commandLineRunner(IProductRepository productRepository) {
        return strings -> {
            //insertar datos
            productRepository.saveAll(new Gson().fromJson(data, new TypeToken<List<ProductDocument>>(){}.getType()));
        };
    }

}