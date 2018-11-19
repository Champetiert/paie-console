package dev.paie.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.domain.Cotisation;
import dev.paie.repository.CotisationRepository;
@Service
public class CotisationServiceMemoire implements CotisationService {
	
	@Autowired private CotisationRepository cotisationRepository;

	@Override
	public List<Cotisation> lister() {	
		return cotisationRepository.findAll();
	}

	@Override
	public Cotisation sauver(String code, String libelle, Boolean imposable, BigDecimal tauxPatronal,
			BigDecimal tauxSalarial) {
		Cotisation cotis= new Cotisation();
		cotis.setCode(code);
		cotis.setLibelle(libelle);
		cotis.setImposable(imposable);
		cotis.setTauxPatronal(tauxPatronal);
		cotis.setTauxSalarial(tauxSalarial);
		return cotisationRepository.save(cotis);
	}

	@Override
	public void supppimer(String code) {
		for (Cotisation cotisation : cotisationRepository.findByCode(code)) {
			cotisationRepository.delete(cotisation);
		}	
	}
	
	

}
