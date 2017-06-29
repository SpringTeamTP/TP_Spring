package JPAClass;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;



@Entity
public class Ville {
	

	
	@Id
	@GeneratedValue
	private long id_Ville;
	private String nom;
	
	@Version
	private int version;
	
	
	
	@OneToMany(mappedBy="ville")
	private List<AeroportVille> aeroportVille = new ArrayList<>();
	
	
	public Ville(){
		
	}

	
	public Ville(Aeroport aeroport, long id_Ville, String nom) {
		super();
		
		this.id_Ville = id_Ville;
		this.nom = nom;
	}


	public long getId_Ville() {
		return id_Ville;
	}

	public void setId_Ville(long id_Ville) {
		this.id_Ville = id_Ville;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}




	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
	
}