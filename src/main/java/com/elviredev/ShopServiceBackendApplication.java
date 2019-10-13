package com.elviredev;

import com.elviredev.dao.CoachedAppliRepository;
import com.elviredev.dao.ContentAppliRepository;
import com.elviredev.entities.CoachedAppli;
import com.elviredev.entities.ContentAppli;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.Random;


@SpringBootApplication
public class ShopServiceBackendApplication {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(ShopServiceBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CoachedAppliRepository coachedAppliRepository, ContentAppliRepository contentAppliRepository){
		repositoryRestConfiguration.exposeIdsFor(ContentAppli.class, CoachedAppli.class);
		return args -> {
			coachedAppliRepository.deleteAll();
			coachedAppliRepository.save(new CoachedAppli("APP01", "Profil de compétences", new ArrayList<>()));
			coachedAppliRepository.save(new CoachedAppli("APP02", "MRS Digitale", new ArrayList<>()));
			coachedAppliRepository.save(new CoachedAppli("APP03", "MAP DE", new ArrayList<>()));
			coachedAppliRepository.findAll().forEach(System.out::println); // appel méthode toString() pour chaque objet coachedAppli


			// supprime les données avant chaque lancement de l'appli
			//contentAppliRepository.deleteAll();
			// save les données contentAppli en BDD
			/*ContentAppli c1 = contentAppliRepository.save(new ContentAppli("c1", "Pastille", app01));
			ContentAppli c2 = contentAppliRepository.save(new ContentAppli("c2", "Info Bulle", app01));
			ContentAppli c3 = contentAppliRepository.save(new ContentAppli("c2", "Vidéo", app02));*/
			// ajout des contents aux applis
			Random rnd = new Random();
			coachedAppliRepository.findAll().forEach(ca -> {
				for (int i = 0; i < 5; i++){
					ContentAppli cnt = new ContentAppli();
					cnt.setContentName(RandomString.make(12));
					cnt.setIdContent(RandomString.make(2));
					cnt.setSelected(rnd.nextBoolean());
					cnt.setCoachedAppli(ca);
					contentAppliRepository.save(cnt);
				}

			});
			/*app01.getContentApplis().add(c1);
			app01.getContentApplis().add(c2);
			app02.getContentApplis().add(c1);

			coachedAppliRepository.save(app01);
			coachedAppliRepository.save(app02);
			contentAppliRepository.findAll().forEach(cnt -> {
				System.out.println(cnt.toString());
			});*/
			contentAppliRepository.findAll().forEach(cnt -> {
				System.out.println(cnt.toString());
			});
		};
	}

}
