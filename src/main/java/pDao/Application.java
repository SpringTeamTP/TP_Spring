package pDao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pDaoProjetJPA.AeroportDao;
import pDaoProjetJPA.AeroportDaoJpa;
import pDaoProjetJPA.ClientDao;
import pDaoProjetJPA.ClientDaoJpa;
import pDaoProjetJPA.ClientEIDao;
import pDaoProjetJPA.ClientEIDaoJpa;
import pDaoProjetJPA.ClientMoralDao;
import pDaoProjetJPA.ClientMoralDaoJpa;
import pDaoProjetJPA.CompagnieAerienneDao;
import pDaoProjetJPA.CompagnieAerienneDaoJpa;
import pDaoProjetJPA.CompagnieAerienneVolDao;
import pDaoProjetJPA.CompagnieAerienneVolDaoJpa;
import pDaoProjetJPA.EscaleDao;
import pDaoProjetJPA.EscaleDaoJpa;
import pDaoProjetJPA.LoginDao;
import pDaoProjetJPA.LoginDaoJpa;
import pDaoProjetJPA.PassagerDao;
import pDaoProjetJPA.PassagerDaoJpa;
import pDaoProjetJPA.ReservationDao;
import pDaoProjetJPA.ReservationDaoJpa;
import pDaoProjetJPA.VilleDao;
import pDaoProjetJPA.VilleDaoJpa;
import pDaoProjetJPA.VolDao;
import pDaoProjetJPA.VolDaoJpa;



public class Application {

	
	private static Application instance;

	private final EntityManagerFactory emf;
	




	
	private final ClientMoralDao clientMoralDao = new ClientMoralDaoJpa();
	private final ClientEIDao clientEIDao = new ClientEIDaoJpa();
	private final LoginDao loginDao = new LoginDaoJpa();
	private final ClientDao clientDao = new ClientDaoJpa();
	private final ReservationDao reservationDao = new ReservationDaoJpa();
	private final VolDao volDao = new VolDaoJpa();
	private final EscaleDao escaleDao = new EscaleDaoJpa();
	private final AeroportDao aeroportDao = new AeroportDaoJpa();
	private final VilleDao villeDao = new VilleDaoJpa();
	private final CompagnieAerienneDao compagnieAerienneDao = new CompagnieAerienneDaoJpa();
	private final CompagnieAerienneVolDao compagnieAerienneVolDao = new CompagnieAerienneVolDaoJpa();
	private final PassagerDao passagerDao = new PassagerDaoJpa();
	
	

	private Application() {
		emf = Persistence.createEntityManagerFactory("ProjetJPA");
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public ClientMoralDao getClientMoralDao() {
		return clientMoralDao;
	}

	public ClientEIDao getClientEIDao() {
		return clientEIDao;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	public ReservationDao getReservationDao() {
		return reservationDao;
	}

	public VolDao getVolDao() {
		return volDao;
	}

	public EscaleDao getEscaleDao() {
		return escaleDao;
	}

	public AeroportDao getAeroportDao() {
		return aeroportDao;
	}

	public VilleDao getVilleDao() {
		return villeDao;
	}

	public CompagnieAerienneDao getCompagnieAerienneDao() {
		return compagnieAerienneDao;
	}

	public CompagnieAerienneVolDao getCompagnieAerienneVolDao() {
		return compagnieAerienneVolDao;
	}

	public PassagerDao getPassagerDao() {
		return passagerDao;
	}

	public static void setInstance(Application instance) {
		Application.instance = instance;
	}


	
	
	
	
}
