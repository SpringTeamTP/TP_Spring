package JPAClassTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import JPAClass.Aeroport;
import JPAClass.ClientPhysique;
import JPAClass.CompagnieAerienne;
import JPAClass.Escale;
import JPAClass.Login;
import JPAClass.Passager;
import JPAClass.Reservation;
import JPAClass.Vol;
import pDao.Application;
import pDaoProjetJPA.AeroportDao;
import pDaoProjetJPA.ClientDao;
import pDaoProjetJPA.ClientEIDao;
import pDaoProjetJPA.ClientMoralDao;
import pDaoProjetJPA.CompagnieAerienneDao;
import pDaoProjetJPA.EscaleDao;
import pDaoProjetJPA.LoginDao;
import pDaoProjetJPA.PassagerDao;
import pDaoProjetJPA.ReservationDao;
import pDaoProjetJPA.VilleDao;
import pDaoProjetJPA.VolDao;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJUnitSpringProjet {

	
	@Autowired
	private AeroportDao aeroportDao;
	
	@Autowired
	private VolDao volDao;
	
	@Autowired
	private EscaleDao escaleDao;
	
	@Autowired
	private VilleDao villeDao;
		
	@Autowired
	private CompagnieAerienneDao compagnieAerienneDao;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private ClientEIDao clientEIDao;
	
	@Autowired
	private ClientMoralDao clientMoralDao;
	
	@Autowired
	private PassagerDao passagerDao;
	
	@Autowired
	private ReservationDao reservationDao;
	
	
	@Autowired
	private LoginDao loginDao;

	@Test
	public void testAeroport() {
		Aeroport aeroport = new Aeroport();
		aeroport.setNom_Aeroport("Roissy - CDG");
		
		
		aeroport.setEscales(null);
		aeroport.setAeroportVille(null);

		aeroportDao.create(aeroport);

		
		
		Aeroport aeroportFind = aeroportDao.find(aeroport.getId_Aeroport());

		Assert.assertEquals("Roissy - CDG", aeroportFind.getNom_Aeroport());
		
		
		
		aeroportFind.setNom_Aeroport("Paris Orly");
		
		
		Aeroport aeroportUpdate = aeroportDao.update(aeroportFind);
		
		
		
		aeroportFind = aeroportDao.find(aeroportUpdate.getId_Aeroport());
		
		Assert.assertEquals("Paris Orly", aeroportFind.getNom_Aeroport());
		
		
		List<Aeroport> aeroports = aeroportDao.findAll();
		
		
		
		aeroportDao.delete(aeroportFind);

		
		
		aeroportFind = aeroportDao.find(aeroportFind.getId_Aeroport());
		
		Assert.assertNull(aeroportFind);
		
		List<Aeroport> aeroportsPostDelete = aeroportDao.findAll();
		
		Assert.assertEquals(1, aeroports.size() - aeroportsPostDelete.size());
	}

	@Test
	public void testVol() throws ParseException {
		
		Vol vol = new Vol();
		
		vol.setCompagnieAerienneVol(null);
		vol.setHeureArrivee(null);
		vol.setHeureDepart(null);
		vol.setEscales(null);
		vol.setReservation(null);
		
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		
		
		String dateDepart = "23/06/2017 13:05";
		
			Date depart = dateFormat.parse(dateDepart);
	
		
		String dateArrivee = "28/06/2017 18:45";
		
			Date arrivee = dateFormat.parse(dateArrivee);
	
		
		vol.setDateDepart(depart);
		vol.setDateArrivee(arrivee);
		
		
		volDao.create(vol);
		
		
		Vol volFind = volDao.find(vol.getId_Vol());
		
		
		Assert.assertEquals("23/06/2017 13:05", dateFormat.format(volFind.getDateDepart()));
		Assert.assertEquals("28/06/2017 18:45", dateFormat.format(volFind.getDateArrivee()));
				
		
		
	}

	@Test
	public void testEscale(){
		Escale jpa = new Escale();
		
		String dateArrivee = "28/06/2017 18:45";
		Date arrivee=null;
		try {
			arrivee = dateFormat.parse(dateArrivee);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jpa.setHeureArrivee(arrivee);
		
		escaleDao.create(jpa);
		
		Escale jpaFind = escaleDao.find(jpa.getId_Escale());
		
		Assert.assertEquals(arrivee, jpaFind.getHeureArrivee());
		
		// Mise à jour de l'heure
		dateArrivee = "28/06/2017 18:45";
		arrivee=null;
		try {
			arrivee = dateFormat.parse(dateArrivee);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jpaFind.setHeureArrivee(arrivee);
		
		Escale jpaUpdate = escaleDao.update(jpaFind);
		
		jpaFind = escaleDao.find(jpaUpdate.getId());
		
		Assert.assertEquals(arrivee, jpaFind.getHeureArrivee());
		
		List<Escale> escales = escaleDao.findAll();
		
		escaleDao.delete(jpaFind);
		
		Assert.assertNull(jpaFind);
		
		List<Escale> escalesPostDelete = escaleDao.findAll();
		
		Assert.assertEquals(1, escales.size() - escalesPostDelete.size());
	}
	
	@Test
	public void testCompagnieAerienne() {

		CompagnieAerienne airFrance = new CompagnieAerienne ();
		airFrance.setNom("AirFrance");
		
		compagnieAerienneDao.create(airFrance);
		
		CompagnieAerienne airFranceFind = compagnieAerienneDao.find(airFrance.getId_CompagnieAerienne());
		
		Assert.assertEquals("AirFrance", airFranceFind.getNom());
		
		airFrance.setNom("AirFrance");
		
		CompagnieAerienne airFranceUpdate = compagnieAerienneDao.update(airFranceFind);
		
		airFranceFind = compagnieAerienneDao.find(airFranceUpdate.getId_CompagnieAerienne());
		
		Assert.assertEquals("AirFrance", airFranceFind.getNom());
		
		List<CompagnieAerienne> compagnieAeriennes = compagnieAerienneDao.findAll();

		compagnieAerienneDao.delete(airFranceFind);

		airFranceFind = compagnieAerienneDao.find(airFranceFind.getId_CompagnieAerienne());
		Assert.assertNull(airFranceFind);

		List<CompagnieAerienne> compagnieAeriennesPostDelete = compagnieAerienneDao.findAll();

		Assert.assertEquals(1, compagnieAeriennes.size() - compagnieAeriennesPostDelete.size());
	}
	
	
	@Test
	public void testReservation() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
		System.out.println("test reservation");
		

		Reservation rs = new Reservation(sdf.parse("01/01/2017"),12);

		reservationDao.create(rs);

		Reservation jpaFind = reservationDao.find(rs.getId_Reservation());

		Assert.assertEquals(sdf.parse("21/06/2017"), jpaFind.getDate());
		Assert.assertEquals(12, jpaFind.getNumero());
		
		
		jpaFind.setDate(sdf.parse("10/02/2017"));
		jpaFind.setNumero(23);
	
		
		Reservation jpaUpdate = reservationDao.update(jpaFind);
		
		jpaFind = reservationDao.find(jpaUpdate.getId_Reservation());
		
		Assert.assertEquals(sdf.parse("10/02/2017"), jpaFind.getDate());
		Assert.assertEquals(23, jpaFind.getNumero());
		
		
		List<Reservation> reservations = reservationDao.findAll();
		
		reservationDao.delete(jpaFind);

		jpaFind = reservationDao.find(jpaFind.getId_Reservation());
		
		Assert.assertNull(jpaFind);
		
		List<Reservation> reservationPostDelete = reservationDao.findAll();
		
		Assert.assertEquals(1, reservations.size() - reservationPostDelete.size());
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	

}
	
	@Test
	public void testPassager() {
		

		Passager jpa = new Passager("Brosse","Virginie");

		passagerDao.create(jpa);

		Passager jpaFind = passagerDao.find(jpa.getId_Passager());

		Assert.assertEquals("Brosse", jpaFind.getNom());
		Assert.assertEquals("Virginie", jpaFind.getPrenom());
		
		jpaFind.setNom("Kwimang");
		jpaFind.setPrenom("Salomon");
		
		Passager jpaUpdate = passagerDao.update(jpaFind);
		
		jpaFind = passagerDao.find(jpaUpdate.getId_Passager());
		
		Assert.assertEquals("Kwimang", jpaFind.getNom());
		Assert.assertEquals("Salomon", jpaFind.getPrenom());
		
		List<Passager> passagers = passagerDao.findAll();
		
		passagerDao.delete(jpaFind);

		jpaFind = passagerDao.find(jpaFind.getId_Passager());
		
		Assert.assertNull(jpaFind);
		
		List<Passager> passagersPostDelete = passagerDao.findAll();
		
		Assert.assertEquals(1, passagers.size() - passagersPostDelete.size());
	}

	
	@Test
	public void testClient() {
		Matiere jpa = new Matiere("JPA", Difficulte.FACILE);

		matiereDao.create(jpa);

		Matiere jpaFind = matiereDao.find(jpa.getId());

		Assert.assertEquals("JPA", jpaFind.getNom());
		Assert.assertEquals(Difficulte.FACILE, jpaFind.getDifficulte());
		
		jpaFind.setNom("JPA/HIBERNATE");
		jpaFind.setDifficulte(Difficulte.IMPOSSIBLE);
		
		Matiere jpaUpdate = matiereDao.update(jpaFind);
		
		jpaFind = matiereDao.find(jpaUpdate.getId());
		
		Assert.assertEquals("JPA/HIBERNATE", jpaFind.getNom());
		Assert.assertEquals(Difficulte.IMPOSSIBLE, jpaFind.getDifficulte());
		
		List<Matiere> matieres = matiereDao.findAll();
		
		matiereDao.delete(jpaFind);

		jpaFind = matiereDao.find(jpaFind.getId());
		
		Assert.assertNull(jpaFind);
		
		List<Matiere> matieresPostDelete = matiereDao.findAll();
		
		Assert.assertEquals(1, matieres.size() - matieresPostDelete.size());
	}
	
	@Test
	public void testClientMoral() {
		Matiere jpa = new Matiere("JPA", Difficulte.FACILE);

		matiereDao.create(jpa);

		Matiere jpaFind = matiereDao.find(jpa.getId());

		Assert.assertEquals("JPA", jpaFind.getNom());
		Assert.assertEquals(Difficulte.FACILE, jpaFind.getDifficulte());
		
		jpaFind.setNom("JPA/HIBERNATE");
		jpaFind.setDifficulte(Difficulte.IMPOSSIBLE);
		
		Matiere jpaUpdate = matiereDao.update(jpaFind);
		
		jpaFind = matiereDao.find(jpaUpdate.getId());
		
		Assert.assertEquals("JPA/HIBERNATE", jpaFind.getNom());
		Assert.assertEquals(Difficulte.IMPOSSIBLE, jpaFind.getDifficulte());
		
		List<Matiere> matieres = matiereDao.findAll();
		
		matiereDao.delete(jpaFind);

		jpaFind = matiereDao.find(jpaFind.getId());
		
		Assert.assertNull(jpaFind);
		
		List<Matiere> matieresPostDelete = matiereDao.findAll();
		
		Assert.assertEquals(1, matieres.size() - matieresPostDelete.size());
	}
	
	@Test
	public void testPhysique(){
		
		 ClientPhysique clientphys = new ClientPhysique();
		 clientphys.setNom("Huynh");
		 clientphys.setPrenom("Albert");
		 clientphys.setNumeroTel(0135326235);
		 clientphys.setNumeroFax(0136656565);
		 clientphys.setEmail( "albert@mail.com");
		 clientphys.setId(null);
		 clientphys.setLogin(null);
		 clientDao.create(clientphys);
		 
		 
		 ClientPhysique cpFind = (ClientPhysique) clientDao.find(clientphys.getId_Client());
		 
		Login loginFind =  loginDao.find(login.getId_Login());		
		Assert.assertEquals("System",loginFind.getLogin());		
		login.setMotDePasse("Formation2017");		
		Login loginUpdate = loginDao.update(loginFind);		
		loginFind = loginDao.find(loginUpdate.getId_Login());		
		Assert.assertEquals("Formation2017",loginFind.getMotDePasse());		
		List<Login> logins = loginDao.findAll();	
		loginDao.delete(loginFind);
		loginFind = loginDao.find(loginFind.getId_Login());	
		Assert.assertNull(loginFind);	
		List<Login> LoginDelete = loginDao.findAll();
		Assert.assertEquals(1, logins.size() - LoginDelete.size());
		

		
	}


	@Test
	public void testLogin() {

		
		Login login = new Login();
		login.setLogin("System");
		login.setMotDePasse("Formation2017");
		login.setAdmin(true);
		loginDao.create(login);	
		Login loginFind =  loginDao.find(login.getId_Login());		
		Assert.assertEquals("System",loginFind.getLogin());		
		login.setMotDePasse("Formation2017");		
		Login loginUpdate = loginDao.update(loginFind);		
		loginFind = loginDao.find(loginUpdate.getId_Login());		
		Assert.assertEquals("Formation2017",loginFind.getMotDePasse());		
		List<Login> logins = loginDao.findAll();	
		loginDao.delete(loginFind);
		loginFind = loginDao.find(loginFind.getId_Login());	
		Assert.assertNull(loginFind);	
		List<Login> LoginDelete = loginDao.findAll();
		Assert.assertEquals(1, logins.size() - LoginDelete.size());

		
	}
	


}
