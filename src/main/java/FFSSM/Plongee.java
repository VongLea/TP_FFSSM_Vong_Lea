/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.*;

public class Plongee {

	public Site lieu;
	public Moniteur chefDePalanquee;
	public LocalDate date;
	public int profondeur;
	public int duree;
        public  Set<Licence> listLicence;

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
                this.listLicence = new HashSet<>();
	}

	public void ajouteParticipant(Licence licence) { // doit enregistrer une licence plutôt qu'un plongeur
            this.listLicence.add(licence);
	}

	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
                for(Licence l: this.listLicence){
                    if(!l.estValide(this.getDate()))
                        return false;
                }
                return true;
	}

}
