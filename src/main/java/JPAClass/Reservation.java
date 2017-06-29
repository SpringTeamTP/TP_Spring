package JPAClass;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;


@Entity
public class Reservation {
		
		@Id @GeneratedValue
		private Long id_Reservation;
		private Date date;
		private int numero;
		
		@ManyToOne
		@JoinColumn(name="id_Passager")
		private Passager passager;
		
		
		@ManyToOne
		@JoinColumn(name="id_Client")
		private Client client;
		
		
		
		@ManyToOne
		@JoinColumn(name="id_Vol")
		private Vol vol;
		
		
		@Version
		private int version;
		
		public Reservation(){
			
		}
		
		
		
		

		public Reservation(Long id_Reservation, Date date, int numero, Passager passager, Client client) {
			super();
			this.id_Reservation = id_Reservation;
			this.date = date;
			this.numero = numero;
			this.passager = passager;
			this.client = client;
		}





		public Long getId_Reservation() {
			return id_Reservation;
		}

		public void setId_Reservation(Long id_Reservation) {
			this.id_Reservation = id_Reservation;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}





		public Passager getPassager() {
			return passager;
		}





		public void setPassager(Passager passager) {
			this.passager = passager;
		}





		public Client getClient() {
			return client;
		}





		public void setClient(Client client) {
			this.client = client;
		}





		public int getVersion() {
			return version;
		}





		public void setVersion(int version) {
			this.version = version;
		}





		public Vol getVol() {
			return vol;
		}





		public void setVol(Vol vol) {
			this.vol = vol;
		}
		
		
		
		
		
		
}
