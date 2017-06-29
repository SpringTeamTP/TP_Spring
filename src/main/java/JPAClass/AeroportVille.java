package JPAClass;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;


@Entity
public class AeroportVille {
	@Id
	@GeneratedValue
	private Long id_AeroportVille;
	
	@Version
	private int version;
	
	
	
	@ManyToOne
	@JoinColumn(name="id_Aeroport")
	private Aeroport aeroport;

	@ManyToOne
	@JoinColumn(name="id_Ville")
	private Ville ville;

	
	
	
	
	
	
	public AeroportVille() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public AeroportVille(Long id_AeroportVille, int version, Aeroport aeroport, Ville ville) {
		super();
		this.id_AeroportVille = id_AeroportVille;
		this.version = version;
		this.aeroport = aeroport;
		this.ville = ville;
	}





	public Long getId_AeroportVille() {
		return id_AeroportVille;
	}

	public void setId_AeroportVille(Long id_AeroportVille) {
		this.id_AeroportVille = id_AeroportVille;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}



	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	
	
}


