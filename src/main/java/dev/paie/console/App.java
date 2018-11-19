package dev.paie.console;

import javax.naming.Context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.paie.config.ServicesConfig;
import dev.paie.ihm.Menu;

/**
 * 1 depandance maven de spring
 * 2 add context (AnnotationConfigApplicationContext ou  xml)
 * 3 
 *
 */
public class App {

	public static void main(String[] args) {
		
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServicesConfig.class)){
			while (true) {
				
				Menu menu=context.getBean(Menu.class);
				menu.demarrer();
			}
		}
//		Scanner scanner = new Scanner(System.in);
//		CotisationService cotisService = new CotisationServiceMemoire();
//		
//		Menu menu = new Menu(scanner, cotisService);
//		menu.demarrer();
//
//		scanner.close();
	}
}
