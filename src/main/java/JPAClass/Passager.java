package JPAClass;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Passager {
	
	

	
	@Id @GeneratedValue
	private Long id_Passager;
	@Embedded
	private Adresse adresse;
	private String nom;
	private String prenom;
	
	@OneToMany(mappedBy="passager")
	private List< Reservation>  reservation = new ArrayList<>();
	
	
	
	@Version
	private int version;
	

	
	public Passager(){
		
	}
	
	
	











	public Passager(Long id_Passager, Adresse adresse, String nom, String prenom, List<Reservation> reservation) {
		super();
		this.id_Passager = id_Passager;
		this.adresse = adresse;
		this.nom = nom;
		this.prenom = prenom;
		this.reservation = reservation;
	}














	public Long getId_Passager() {
		return id_Passager;
	}

	public void setId_Passager(Long id_Passager) {
		this.id_Passager = id_Passager;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}














	public Adresse getAdresse() {
		return adresse;
	}














	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}














	public List<Reservation> getReservation() {
		return reservation;
	}














	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}














	public int getVersion() {
		return version;
	}














	public void setVersion(int version) {
		this.version = version;
	}




	
	
	
	
}
