package com.elviredev;

import com.elviredev.dao.CategoryRepository;
import com.elviredev.dao.ProductRepository;

import com.elviredev.entities.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class ShopServiceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopServiceBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CategoryRepository categoryRepository, ProductRepository productRepository){
		return args -> {
			categoryRepository.deleteAll();
			Stream.of("C1 Ordinateurs", "C2 Imprimantes").forEach(c -> {
				categoryRepository.save(new Category(c.split(" ")[0], c.split(" ")[1], new ArrayList<>()));
			});

			categoryRepository.findAll().forEach(System.out::println); // appelle la méthode toString() pour chaque objet category
		};
	}

}
