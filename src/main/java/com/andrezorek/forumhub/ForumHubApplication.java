package com.andrezorek.forumhub;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumHubApplication {

	public static void main(String[] args) {

		// Carrega as variáveis do .env antes de iniciar o Spring Boot
		Dotenv dotenv = Dotenv.configure()
				.directory("./") // Diretório do .env (raiz do projeto)
				.load();

		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(ForumHubApplication.class, args);
	}

}
