package dev.paie.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class Menu {

	private Map<Integer, OptionMenu> options = new HashMap<>();
	private Scanner scanner;

	@Autowired
	public Menu(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		init(scanner, cotisService, context);
		this.scanner = scanner;
	}

	private void init(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		//crée une avec clé du bean et valeur les classe de type OptionMenu
		Map<String, OptionMenu> beansTrouves = context.getBeansOfType(OptionMenu.class);

		//remplace i++ dans le forEach
		AtomicInteger increment = new AtomicInteger();
		//pour chaque OptionMenu on lui attribut un idantifiant
		beansTrouves.forEach((key, value) -> {
			this.options.put(increment.incrementAndGet(), value);
		});
	}

	public void demarrer() {

		// Afficher les libellés des options
		this.options.forEach((key, option) -> {
			System.out.println(key + ". " + option.getLibelle());
		});

		int optionMenuChoisie = this.scanner.nextInt();

		this.options.get(optionMenuChoisie).executer();

	}

}
