package com.example.demo;

import com.example.demo.data.Voiture;
import com.example.demo.data.VoitureRepository;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private VoitureRepository voitureRepository;

	private static final Logger logger = LoggerFactory.getLogger(VoitureRepository.class);

	public static void main(String[] args) { SpringApplication.run(DemoApplication.class, args);	}

	@Override
	public void run(String... args) throws Exception {


//		Implémentation de l'interface CommandLineRunner
//
//			Permet d'éxécuter des instructions avant le lancement'

		voitureRepository.save(new Voiture("Ford",59000));
		voitureRepository.save(new Voiture("Nissan",4999));

		//	Parcours de toutes les voitures de la base de données

		/*for (Voiture v : VoitureRepository.findAll()){
			Logger.info(v.getMarque() + "" + v.getPrix());
		}*/
	}
}
