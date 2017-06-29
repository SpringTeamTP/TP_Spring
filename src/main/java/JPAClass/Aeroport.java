package JPAClass;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Aeroport {
	
	 
	 @OneToMany(mappedBy="aeroports")
	 private List<Escale>escales=new ArrayList<>();
	
	 @Id
	 @GeneratedValue
	private Long id_Aeroport;
	private String nom_Aeroport;
	@Version
	private int version;
	
	
	@OneToMany(mappedBy="aeroport")
	private List<AeroportVille> aeroportVille = new ArrayList<>();
	
	
	
	public Aeroport() {
		super();
	}
	public Aeroport(Long id_Aeroport, String nom_Aeroport) {
		super();
		
		this.id_Aeroport = id_Aeroport;
		this.nom_Aeroport = nom_Aeroport;
	}

	
	public String getNom_Aeroport() {
		return nom_Aeroport;
	}
	public void setNom_Aeroport(String nom_Aeroport) {
		this.nom_Aeroport = nom_Aeroport;
	}

	public List<Escale> getEscales() {
		return escales;
	}
	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Long getId_Aeroport() {
		return id_Aeroport;
	}
	public void setId_Aeroport(Long id_Aeroport) {
		this.id_Aeroport = id_Aeroport;
	}
	public List<AeroportVille> getAeroportVille() {
		return aeroportVille;
	}
	public void setAeroportVille(List<AeroportVille> aeroportVille) {
		this.aeroportVille = aeroportVille;
	}

	

	
}