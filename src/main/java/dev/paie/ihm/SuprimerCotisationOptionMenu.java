package dev.paie.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationServiceMemoire;

@Controller
public class SuprimerCotisationOptionMenu extends OptionMenu {

	@Autowired Scanner scanner;
	@Autowired CotisationServiceMemoire cotisation;

	public SuprimerCotisationOptionMenu() {
			super("Suprime une cotisation");
		}

	@Override
	public void executer() {
		System.out.println("Veuillez saisir le code : ");
		String codeSaisie = this.scanner.next();
		System.out.println("supretion de "+codeSaisie);
		cotisation.supppimer(codeSaisie);
	}

}
