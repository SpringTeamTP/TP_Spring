package JPAClass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("TitreMoral")
public class ClientMoral extends Client{
	
		private String siret;
		
		
		//@Version
		//private int version;
		
		
		public ClientMoral(){
			
		}
		
		
		
		

		public ClientMoral(String siret) {
			super();
			this.siret = siret;
		}





		public String getSiret() {
			return siret;
		}

		public void setSiret(String siret) {
			this.siret = siret;
		}





/*		public int getVersion() {
			return version;
		}





		public void setVersion(int version) {
			this.version = version;
		}
		*/
		
		
}

