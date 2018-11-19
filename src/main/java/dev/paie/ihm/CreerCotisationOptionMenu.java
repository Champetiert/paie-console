package dev.paie.ihm;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.naming.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationServiceMemoire;
@Controller
public class CreerCotisationOptionMenu extends OptionMenu {

	private Scanner scanner;
	@Autowired CotisationServiceMemoire cotisation;

	public CreerCotisationOptionMenu(Scanner scanner) {
		super("Créer une cotisation");
		this.scanner = scanner;
	}

	@Override
	public void executer() {
		System.out.println("Création en cours");
		
		System.out.println("Veuillez saisir le code : ");
		String codeSaisie = this.scanner.next();
		System.out.println("Vous avez saisie :" + codeSaisie);
		
		System.out.println("Veuillez saisir le libelle : ");
		String libelle = this.scanner.next();
		System.out.println("Vous avez saisie :" + libelle);
		
		System.out.println("Imposable : ");
		boolean imposable = this.scanner.nextBoolean();
		System.out.println("Vous avez saisie :" + imposable);
		
		System.out.println("Veuillez saisir le taux Salarial : ");
		String tauxSalarial = this.scanner.next();
		System.out.println("Vous avez saisie :" + tauxSalarial);
		
		System.out.println("Veuillez saisir le taux Patronal : ");
		String tauxPatronal = this.scanner.next();
		System.out.println("Vous avez saisie :" + tauxPatronal);
			
		cotisation.sauver(codeSaisie, libelle, imposable,new BigDecimal(tauxSalarial) , new BigDecimal(tauxPatronal));	
		
		
	}

}
