/**
 * @(#) Site.java
 */

package FFSSM;

public class Site
{
	public String nom;
        private String details;

	public Site(String nom, String details) {
		this.nom = nom;
		this.details = details;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Get the value of details
	 *
	 * @return the value of details
	 */
	public String getDetails() {
		return this.details;
	}

	/**
	 * Set the value of details
	 *
	 * @param details new value of details
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Site{" + "nom=" + nom + ", details=" + details + '}';
	}

	
}
