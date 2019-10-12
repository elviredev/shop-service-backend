package com.elviredev;

import com.elviredev.dao.CoachedAppliRepository;
import com.elviredev.dao.ContentAppliRepository;
import com.elviredev.entities.CoachedAppli;
import com.elviredev.entities.ContentAppli;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


@SpringBootApplication
public class ShopServiceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopServiceBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CoachedAppliRepository coachedAppliRepository, ContentAppliRepository contentAppliRepository){
		return args -> {
			coachedAppliRepository.deleteAll();
			CoachedAppli app01 = coachedAppliRepository.save(new CoachedAppli("APP01", "Profil de compétences", new ArrayList<>()));
			CoachedAppli app02 = coachedAppliRepository.save(new CoachedAppli("APP02", "MRS Digitale", new ArrayList<>()));
			CoachedAppli app03 = coachedAppliRepository.save(new CoachedAppli("APP03", "MAP DE", new ArrayList<>()));
			coachedAppliRepository.findAll().forEach(System.out::println); // appel méthode toString() pour chaque objet coachedAppli


			// supprime les données avant chaque lancement de l'appli
			contentAppliRepository.deleteAll();
			// save les données contentAppli en BDD
			ContentAppli c1 = contentAppliRepository.save(new ContentAppli("c1", "Pastille", app01));
			ContentAppli c2 = contentAppliRepository.save(new ContentAppli("c2", "Info Bulle", app01));
			ContentAppli c3 = contentAppliRepository.save(new ContentAppli("c2", "Vidéo", app02));
			// ajout des contents aux applis
			app01.getContentApplis().add(c1);
			app01.getContentApplis().add(c2);
			app02.getContentApplis().add(c1);

			coachedAppliRepository.save(app01);
			coachedAppliRepository.save(app02);
			contentAppliRepository.findAll().forEach(cnt -> {
				System.out.println(cnt.toString());
			});
		};
	}

}
