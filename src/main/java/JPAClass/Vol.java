package JPAClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;


@Entity
public class Vol {
		
	@Id
	@GeneratedValue
	private Long id_Vol;
	private Date dateDepart;
	private Date dateArrivee;
	private Date heureDepart;
	private Date heureArrivee;

	@OneToMany(mappedBy="vol")
	List<Reservation>reservation=new ArrayList<>();
	
	@Version
	private int version;
	
	@OneToMany(mappedBy="vols")
	private List<Escale> escales=new ArrayList<>();
	
	
	@OneToMany(mappedBy="vol")
	private List<CompagnieAerienneVol> compagnieAerienneVol = new ArrayList<>();
	
	public Vol(){
		
	}

	public long getId_Vol() {
		return id_Vol;
	}

	public void setId_Vol(long id_Vol) {
		this.id_Vol = id_Vol;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
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

	public void setId_Vol(Long id_Vol) {
		this.id_Vol = id_Vol;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public List<CompagnieAerienneVol> getCompagnieAerienneVol() {
		return compagnieAerienneVol;
	}

	public void setCompagnieAerienneVol(List<CompagnieAerienneVol> compagnieAerienneVol) {
		this.compagnieAerienneVol = compagnieAerienneVol;
	}
	
	

}