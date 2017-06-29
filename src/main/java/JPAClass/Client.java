package JPAClass;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "titre", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class Client {
		
	
		@Embedded
		private Adresse id;
	
		@Id @GeneratedValue
		private Long id_Client;
		private String nom;
		private int  numeroTel;
		private int numeroFax;
		private String email;
		
		
		
		@OneToMany(mappedBy="client")
		private List< Reservation>  reservation = new ArrayList<>();
		
		
		
		@OneToOne
		@JoinColumn(name="id_Login")
		private Login login;
		
		
		@Version
		private int version;
		
		
		public Client()
		{
			
		}
		
		
		
		



		













		public Client(Adresse id, Long id_Client, String nom, int numeroTel, int numeroFax, String email,
				List<Reservation> reservation, Login login) {
			super();
			this.id = id;
			this.id_Client = id_Client;
			this.nom = nom;
			this.numeroTel = numeroTel;
			this.numeroFax = numeroFax;
			this.email = email;
			this.reservation = reservation;
			this.login = login;
		}





















		public int getVersion() {
			return version;
		}





















		public void setVersion(int version) {
			this.version = version;
		}





















		public Adresse getId() {
			return id;
		}





		public void setId(Adresse id) {
			this.id = id;
		}





		public Long getId_Client() {
			return id_Client;
		}
		public void setId_Client(Long id_Client) {
			this.id_Client = id_Client;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public int getNumeroTel() {
			return numeroTel;
		}
		public void setNumeroTel(int numeroTel) {
			this.numeroTel = numeroTel;
		}
		public int getNumeroFax() {
			return numeroFax;
		}
		public void setNumeroFax(int numeroFax) {
			this.numeroFax = numeroFax;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}












		public List<Reservation> getReservation() {
			return reservation;
		}





















		public void setReservation(List<Reservation> reservation) {
			this.reservation = reservation;
		}





















		public Login getLogin() {
			return login;
		}










		public void setLogin(Login login) {
			this.login = login;
		}
		
		
		
		
}
