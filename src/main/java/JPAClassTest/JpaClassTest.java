package JPAClassTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import JPAClass.Adresse;
import JPAClass.Aeroport;
import JPAClass.AeroportVille;
import JPAClass.ClientMoral;
import JPAClass.ClientPhysique;
import JPAClass.CompagnieAerienne;
import JPAClass.CompagnieAerienneVol;
import JPAClass.Escale;
import JPAClass.Login;
import JPAClass.Passager;
import JPAClass.Reservation;
import JPAClass.Ville;
import JPAClass.Vol;

public class JpaClassTest {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJPA");
		EntityManager em = null;
		EntityTransaction tx = null;
		
		
		
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			

			
			 
			 
			 Login login = new Login();
			 login.setLogin("System");
			 login.setMotDePasse("Formation2017");
			 login.setAdmin(true);
			 
			 
			 
			 
			 Adresse adresse = new Adresse("6 rue Rougemont", "75009", "Paris", "France");
			 
			 ClientPhysique clientphys = new ClientPhysique();
			 clientphys.setNom("Huynh");
			 clientphys.setPrenom("Albert");
			 clientphys.setNumeroTel(0135326235);
			 clientphys.setNumeroFax(0136656565);
			 clientphys.setEmail( "albert@mail.com");
			 clientphys.setId(adresse);
			 clientphys.setLogin(login);
			 
			 
			 
			 
			 ClientMoral clientmoral = new ClientMoral();
			 clientmoral.setNom("AJC");
			 clientmoral.setNumeroTel(0102030405);
			 clientmoral.setNumeroFax(0102030406);
			 clientmoral.setEmail( "ajc@mail.com");
			 clientmoral.setSiret("0023111131");
			 clientmoral.setId(adresse);
			 clientmoral.setLogin(login);
			 
			 
			 Passager passager = new Passager();
			 passager.setNom("Huynh");
			 passager.setPrenom("Albert");
			 
			 passager.setAdresse(adresse);
			 
			 
			 
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				String dateDepart = "23/06/2017 13:05";
				Date depart = dateFormat.parse(dateDepart);
				
				String dateArrivee = "28/06/2017 18:45";
				Date arrivee = dateFormat.parse(dateArrivee);
			
				
				
			 Vol vol = new Vol();
			 vol.setDateDepart(depart);
			 vol.setDateArrivee(arrivee);
			 vol.setHeureDepart(null);
			 vol.setHeureArrivee(null);
			
			 
			 
			 
			 CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
			 compagnieAerienne.setNom("Air France");
			 
			 
			 
			 
			 CompagnieAerienneVol compagnieAerienneVol = new CompagnieAerienneVol();
			 compagnieAerienneVol.setNumero("AF 1475");
			 compagnieAerienneVol.setCompagnieAerienne(compagnieAerienne);
			 compagnieAerienneVol.setVol(vol);
			 
			 
			 
			 Aeroport aeroport = new Aeroport();
			 aeroport.setNom_Aeroport("Roissy - CDG");
			 
			 
			 
			 Escale escale = new Escale();
			 escale.setHeureDepart(depart);
			 escale.setHeureArrivee(arrivee);
			 escale.setAeroports(aeroport);
			 escale.setVols(vol);
			 
			 
			 Ville ville = new Ville();
			 ville.setNom("Roissy-En-France");
			 
			 
			 
			 AeroportVille aeroportVille = new AeroportVille();
			 aeroportVille.setAeroport(aeroport);
			 aeroportVille.setVille(ville);
			 
			 
			 
			Reservation testreservation = new Reservation();
			
	
			 testreservation.setDate(depart);
			 
			 testreservation.setNumero(3744);
			
			 testreservation.setClient(clientmoral);
			 
			 testreservation.setClient(clientphys);
			 
			 testreservation.setPassager(passager);
			 
			 
			 
			 testreservation.setVol(null);
			 
			 
			 
			 em.persist(aeroportVille);
			 em.persist(ville);
			 em.persist(escale);
			 em.persist(aeroport);
			 em.persist(vol);
			 em.persist(compagnieAerienne);
			 em.persist(compagnieAerienneVol);
			 
			 em.persist(login);
			 
			 em.persist(clientmoral);
			 em.persist(clientphys);
			 
			em.persist(testreservation);
			em.persist(passager);
			
	

			tx.commit(); 

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		emf.close();

	}

		

	}


