/**
 * @(#) Personne.java
 */

package FFSSM;

import java.time.LocalDate;

public class Personne
{
	public String numeroINSEE;
	public String nom;
	public String prenom;
	public String adresse;
	public String telephone;
	public LocalDate naissance;

    public Personne(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        setNumeroINSEE(numeroINSEE); // Le mutateur fait le contrôle non null
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.naissance = naissance;
    }

    public String getNumeroINSEE() {
        return this.numeroINSEE;
    }

    public void setNumeroINSEE(String numeroINSEE) {
        // Vérifier la cardinalité implicite [1]
	if (null == numeroINSEE)
		throw new IllegalArgumentException("numeroINSEE is null");
        this.numeroINSEE = numeroINSEE;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public LocalDate getNaissance() {
        return this.naissance;
    }

    public void setNaissance(LocalDate naissance) {
        this.naissance = naissance;
    }	
}
