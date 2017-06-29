package JPAClassTest;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import pDao.Application;
import pDaoProjetJPA.AeroportDao;
import pDaoProjetJPA.ClientDao;
import pDaoProjetJPA.CompagnieAerienneDao;
import pDaoProjetJPA.CompagnieAerienneVolDao;
import pDaoProjetJPA.EscaleDao;
import pDaoProjetJPA.LoginDao;
import pDaoProjetJPA.PassagerDao;
import pDaoProjetJPA.ReservationDao;
import pDaoProjetJPA.VilleDao;
import pDaoProjetJPA.VolDao;

public class TestFormationWithDao {

	public static void main(String[] args) {
		
		LoginDao lgDao  = Application.getInstance().getLoginDao();
		 Login login = new Login();
		 login.setLogin("System");
		 login.setMotDePasse("Formation2017");
		 login.setAdmin(true);
		 lgDao.create(login);
		 
		 
		 
		
		 Adresse adresse = new Adresse("6 rue Rougemont", "75009", "Paris", "France");
		 
		 ClientDao clientDao = Application.getInstance().getClientDao();
		 
		 ClientPhysique clientphys = new ClientPhysique();
		 clientphys.setNom("Huynh");
		 clientphys.setPrenom("Albert");
		 clientphys.setNumeroTel(0135326235);
		 clientphys.setNumeroFax(0136656565);
		 clientphys.setEmail( "albert@mail.com");
		 clientphys.setId(adresse);
		 clientphys.setLogin(login);
		 clientDao.create(clientphys);
		 
		 
		
		 ClientMoral clientmoral = new ClientMoral();
		 clientmoral.setNom("AJC");
		 clientmoral.setNumeroTel(0102030405);
		 clientmoral.setNumeroFax(0102030406);
		 clientmoral.setEmail( "ajc@mail.com");
		 clientmoral.setSiret("0023111131");
		 clientmoral.setId(adresse);
		 clientmoral.setLogin(login);
		 clientDao.create(clientmoral);
		 
		 
		 PassagerDao psgDao = Application.getInstance().getPassagerDao();
		 Passager passager = new Passager();
		 passager.setNom("Huynh");
		 passager.setPrenom("Albert");
		 
		 passager.setAdresse(adresse);
		 
		 psgDao.create(passager);
		 
		 
		 
		 VolDao volDao = Application.getInstance().getVolDao();
		 
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String dateDepart = "23/06/2017 13:05";
			Date depart=null;
			try {
				depart = dateFormat.parse(dateDepart);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String dateArrivee = "28/06/2017 18:45";
			Date arrivee=null;
			try {
				arrivee = dateFormat.parse(dateArrivee);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
		 Vol vol = new Vol();
		 vol.setDateDepart(depart);
		 vol.setDateArrivee(arrivee);
		 vol.setHeureDepart(null);
		 vol.setHeureArrivee(null);
		
		 volDao.create(vol);
		 
		 
		 
		 CompagnieAerienneDao caDao = Application.getInstance().getCompagnieAerienneDao();
		 CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		 compagnieAerienne.setNom("Air France");
		 caDao.create(compagnieAerienne);
		 
		 
		 CompagnieAerienneVolDao cavDao = Application.getInstance().getCompagnieAerienneVolDao();
		 CompagnieAerienneVol compagnieAerienneVol = new CompagnieAerienneVol();
		 compagnieAerienneVol.setNumero("AF 1475");
		 compagnieAerienneVol.setCompagnieAerienne(compagnieAerienne);
		 compagnieAerienneVol.setVol(vol);
		 cavDao.create(compagnieAerienneVol);
		 
		 
		 AeroportDao aeroDao = Application.getInstance().getAeroportDao();
		 Aeroport aeroport = new Aeroport();
		 aeroport.setNom_Aeroport("Roissy - CDG");
		 aeroDao.create(aeroport);
		 
		 
		 EscaleDao escaleDao = Application.getInstance().getEscaleDao();
		 Escale escale = new Escale();
		 escale.setHeureDepart(depart);
		 escale.setHeureArrivee(arrivee);
		 escale.setAeroports(aeroport);
		 escale.setVols(vol);
		 escaleDao.create(escale);
		 
		 
		 VilleDao villeDao = Application.getInstance().getVilleDao();
		 Ville ville = new Ville();
		 ville.setNom("Roissy-En-France");
		 villeDao.create(ville);
		 
		 
	 
		/* AeroportVille aeroportVille = new AeroportVille();
		 aeroportVille.setAeroport(aeroport);
		 aeroportVille.setVille(ville);
		*/
		 
		 
		ReservationDao rsvDao = Application.getInstance().getReservationDao();
		Reservation testreservation = new Reservation();
		

		 testreservation.setDate(depart);
		 
		 testreservation.setNumero(3744);
		
		 testreservation.setClient(clientmoral);
		 
		 testreservation.setClient(clientphys);
		 
		 testreservation.setPassager(passager);
		 
		 
		 
		 testreservation.setVol(null);
		 
		 rsvDao.create(testreservation);
		 
	
			
	}

}