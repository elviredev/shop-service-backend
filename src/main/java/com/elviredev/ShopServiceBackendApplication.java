package com.elviredev;

import com.elviredev.dao.CategoryRepository;
import com.elviredev.dao.ProductRepository;

import com.elviredev.entities.Category;
import com.elviredev.entities.Product;
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

			// supprime les données avant chaque lancement de l'appli
			productRepository.deleteAll();
			// récupère la catégorie c1
			Category c1 = categoryRepository.findById("C1").get();
			// parcourt et enregistre les données
			Stream.of("P1", "P2", "P3", "P4").forEach(name -> {
				Product p = productRepository.save(new Product(null, name, Math.random()*1000, c1));
				c1.getProducts().add(p);
				categoryRepository.save(c1);
			});

			// récupère la catégorie c2
			Category c2 = categoryRepository.findById("C2").get();
			Stream.of("P5", "P6").forEach(name -> {
				Product p = productRepository.save(new Product(null, name, Math.random()*1000, c2));
				c2.getProducts().add(p);
				categoryRepository.save(c2);
			});

			productRepository.findAll().forEach(p -> {
				System.out.println(p.toString());
			});
		};
	}

}
