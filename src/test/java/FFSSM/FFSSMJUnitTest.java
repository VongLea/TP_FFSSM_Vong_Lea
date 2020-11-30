/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.util.*;
import java.time.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Léa
 */
public class FFSSMJUnitTest {
    
        Plongeur plongeur1;
        
        Club club1;
        Moniteur moniteur1;
        
        Plongeur plongeur2;
        Licence licence2;
        Licence licence3;
        Club club2;
        Moniteur moniteur2;
        Site site2;
        Plongee plongee2;
        
        Club club3;
        Moniteur moniteur3;
        
        Plongeur plongeur4; 
        Licence licence4;
        Club club4;
        Moniteur moniteur4;
        
        Plongeur plongeur5;
        Licence licence5;
        Licence licence6;
        Club club5; // L'objet à tester
        Moniteur moniteur5;
        Site site5;
        Plongee plongee5;
        Plongee plongee6;
		
	@BeforeEach
	public void setUp() {
            plongeur1 = new Plongeur("1234567890123", "Dupont", "Jean", "avenue Jean Moulin", "232", LocalDate.of(1800, 4, 25), 0);
            moniteur1 = new Moniteur("2345678901234", "Doe", "Joe", "avenue Jean Moulin", "3630", LocalDate.of(2006, 6, 6), 3, 456);
            club1 = new Club(moniteur1, "Blue wave", "222");
            
            
            moniteur2 = new Moniteur("1234567890123", "Doe", "Joe", "avenue Jean Moulin", "3630", LocalDate.of(2006, 6, 6), 3, 456);
            club2 = new Club(moniteur2, "Blue wave", "222");
            plongeur2 = new Plongeur("2345678901234", "Dupont", "Jean", "avenue Jean Moulin", "232", LocalDate.of(1800, 4, 25), 0);
            licence2 = new Licence(moniteur2,"5663", LocalDate.of(2020,12,31), club2);
            site2 = new Site("L'océan", "paysages");
            plongee2 = new Plongee (site2, moniteur2, LocalDate.of(2021,01,01), 5000, 30);
            
            moniteur3 = new Moniteur("1234567890123", "Doe", "John", "avenue Jean Moulin", "3630", LocalDate.of(2006, 6, 6), 3, 456);
            club3 = new Club(moniteur3, "Blue wave", "222");
            
            moniteur4 = new Moniteur("1234567890123", "Doe", "John", "avenue Jean Moulin", "3630", LocalDate.of(2006, 6, 6), 3, 456);
            club4 = new Club(moniteur4, "Blue wave", "222");
            plongeur4 = new Plongeur("2345678901234", "Dupont", "Jean", "avenue Jean Moulin", "232", LocalDate.of(1800, 4, 25), 0);
            
            moniteur5 = new Moniteur("1234567890123", "Doe", "John", "avenue Jean Moulin", "3630", LocalDate.of(2006, 6, 6), 3, 456);
            club5 = new Club(moniteur5, "Blue wave", "222");
            plongeur5 = new Plongeur("2345678901234", "Dupont", "Jean", "avenue Jean Moulin", "232", LocalDate.of(1800, 4, 25), 0);
            licence5 = new Licence(moniteur5,"5663", LocalDate.of(2020,12,31), club5);
            site5 = new Site("Les montagnes", "belles vues");
            plongee5 = new Plongee (site5, moniteur5, LocalDate.of(2021,01,01), 5000, 30);
            plongee6 = new Plongee (site5, moniteur5, LocalDate.of(2021,01,02), 5000, 30);
        }
        
        // Tests de la classe Personne
        
        @Test
        public void TestNumeroInsee() {
            try {
                plongeur1 = new Plongeur(null, "Saint", "Bernard", "chateau", "112", LocalDate.of(1800, 4, 25), 0);
                fail();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
        
        
        // Tests de la classe Plongeur

        @Test
        public void TestAjoutLicence() {
            Licence licence1 = new Licence(plongeur1, "2525", LocalDate.of(2020, 12, 31), club1);
            plongeur1.ajouteLicence(licence1.getNumero(), licence1.getDelivrance(), licence1.getClub());
            assertEquals(plongeur1.myLicences.get(plongeur1.myLicences.size()-1).getNumero(),licence1.getNumero(), "La licence n'a pas été ajoutée");
        }
	
        
        
        // Tests de la classe Plongee
        
        @Test
        public void TestEstConforme(){
            licence3 = new Licence(plongeur2,"4585", LocalDate.of(2020,12,12), club2);
            plongee2.ajouteParticipant(licence3);
            assertTrue(plongee2.estConforme(), "La plongée n'est pas conforme.");
        }

        @Test
        public void TestNonConforme(){
            licence3 = new Licence(plongeur2,"7474", LocalDate.of(2018,12,31), club2);
            plongee2.ajouteParticipant(licence3);
            assertFalse(plongee2.estConforme(), "La plongée est conforme.");
        }


        
        
        
        // Tests de la classe Embauche

        @Test
        public void TestEmployeurActuel() {
            moniteur3.nouvelleEmbauche(club3, LocalDate.of(2020, 11, 25));
            assertEquals(club3.toString(), moniteur3.employeurActuel().orElse(null).toString(), "L'employeur actuel n'est pas le bon");
        }

        @Test
        public void TestTerminerEmbauche() {
            moniteur3.nouvelleEmbauche(club3, LocalDate.of(2020, 11, 25));
            moniteur3.terminerEmbauche(LocalDate.of(2020, Month.DECEMBER, 25));
            assertTrue(moniteur3.emplois().get(this.moniteur3.emplois().size()-1).estTerminee(), "L'emploi est censé être fini");
        }
        
        
        // Tests de la classe Licence

        @Test
        public void TestLicenceNonValide() {
            licence4 = new Licence(plongeur4, "2525", LocalDate.of(2020, 12, 31), club4);
            assertFalse(licence4.estValide(LocalDate.of(2022, 1, 11)), "La licence doit être invalide");
        }

        @Test
        public void TestLicenceValide() {
            licence4 = new Licence(plongeur4, "2525", LocalDate.of(2020, 12, 30), club4);
            assertTrue(licence4.estValide(LocalDate.of(2020, 12, 31)), "La licence doit être valide");
        }
        
        
        // Tests de la classe Plongee

        @Test
        public void TestPlongeeConforme(){
            licence6=new Licence(plongeur5,"8456", LocalDate.of(2020,12,31), club5);
            plongee5.ajouteParticipant(licence6);
            plongee6.ajouteParticipant(licence6);
            club5.organisePlongee(plongee5);
            club5.organisePlongee(plongee6);
            assertTrue(club5.plongeesNonConformes().isEmpty(), "Toutes les plongées sont censées être conformes");
        }

        public void TestPlongeeNonConforme(){
            licence6 = new Licence(plongeur5,"8456", LocalDate.of(2012,12,31), club5);
            plongee5.ajouteParticipant(licence6);
            plongee6.ajouteParticipant(licence6);
            club5.organisePlongee(plongee5);
            club5.organisePlongee(plongee6);
            Set<Plongee> plongees = new HashSet<>();
            plongees.add(plongee6);
            plongees.add(plongee5);
            assertEquals(plongees, club5.plongeesNonConformes(), "Les plongées ne sont pas censés être conformes");
        }
}
