package JPAClass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("TitreEi")
public class ClientEI extends ClientMoral{

	private String prenom;
	
	
	/*@Version
	private int version;*/
	
	
	public ClientEI(){	
	}

	
	
	
	public ClientEI(String prenom) {
		super();
		this.prenom = prenom;
	}




	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




/*	public int getVersion() {
		return version;
	}




	public void setVersion(int version) {
		this.version = version;
	}
	*/
	
	
}
