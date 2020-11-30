/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public List<Embauche> myEmbauches = new LinkedList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        if ((this.myEmbauches.isEmpty()) || (this.myEmbauches.get(this.myEmbauches.size()-1).estTerminee())) {
            return Optional.empty();
        }
        return Optional.ofNullable(this.myEmbauches.get(this.myEmbauches.size()-1).getEmployeur());
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        Embauche e = new Embauche(debutNouvelle, this, employeur);
        this.myEmbauches.add(e);  
    }

    public List<Embauche> emplois() {
        return this.myEmbauches;
    }
    
    public void terminerEmbauche(LocalDate fin) {
        
        this.myEmbauches.get(this.myEmbauches.size()-1).terminer(fin);
    }

}