/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.*;

public class Club {

    public Moniteur president;
    public String nom;
    public String adresse;
    public String telephone;
    public List<Plongee> myPlongees = new LinkedList<>(); 

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
        Set<Plongee> listPlongeeNonConformes = new HashSet<>();
        for (Plongee p : myPlongees) {
            if (!p.estConforme()) {
                listPlongeeNonConformes.add(p);
            }
        }
        return listPlongeeNonConformes;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        this.myPlongees.add(p);
    }
    
    
    public Moniteur getPresident() {
        return this.president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
