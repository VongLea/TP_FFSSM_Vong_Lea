package FFSSM;

import java.time.*;
import java.util.*;

public class Plongeur extends Personne {

    private int niveau;
    public List<Licence> myLicences = new ArrayList<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }
    
    public void ajouteLicence(String numero, LocalDate delivrance, Club club) {
        this.myLicences.add(new Licence(this, numero, delivrance, club));
    }
    
}
