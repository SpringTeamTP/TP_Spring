package JPAClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class CompagnieAerienneVol {
	
	@Id
	@GeneratedValue
	private Long id_CompagnieAerienneVol;
	
	private String numero;
	
	@Version
	private int version;
	
	@ManyToOne
	@JoinColumn(name="id_CompagnieAerienne")
	private CompagnieAerienne compagnieAerienne;

	@ManyToOne
	@JoinColumn(name="id_Vol")
	private Vol vol;
	
	public CompagnieAerienneVol(){
		
	}

	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}


	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}


	public Vol getVol() {
		return vol;
	}


	public void setVol(Vol vol) {
		this.vol = vol;
	}


	public Long getId_CompagnieAerienneVol() {
		return id_CompagnieAerienneVol;
	}


	public void setId_CompagnieAerienneVol(Long id_CompagnieAerienneVol) {
		this.id_CompagnieAerienneVol = id_CompagnieAerienneVol;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
	
}