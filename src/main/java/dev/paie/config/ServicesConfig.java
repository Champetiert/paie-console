package dev.paie.config;

import java.util.Scanner;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"dev.paie.service","dev.paie.ihm"})
@EnableJpaRepositories("dev.paie.repository")
@Import(JpaConfig.class)
public class ServicesConfig {
		
		Scanner scanner;

		@Bean
		public Scanner scanner() {
			this.scanner=new Scanner(System.in);
			return this.scanner;
		}
		
		@PreDestroy
		public void closeScanAtTheEnd() {
			System.out.println("close scan");
			scanner.close();
		}
}