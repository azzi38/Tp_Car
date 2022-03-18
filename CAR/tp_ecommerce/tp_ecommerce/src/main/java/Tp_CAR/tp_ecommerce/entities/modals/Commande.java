package Tp_CAR.tp_ecommerce.entities.modals;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long idCommande;
	 @ManyToMany
	private Collection<Product> lignes;
	 @Column(length=10000000)
	 private Client client;
	public Commande() {
		super();
	}

	public Commande(Collection<Product> lignes, Client client) {
		super();
		
		this.lignes = lignes;
		this.client = client;
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Collection<Product> getLignes() {
		return lignes;
	}

	public void setLignes(Collection<Product> lignes) {
		this.lignes = lignes;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client clientId) {
		this.client = clientId;
	}
	
	
	
	

}
