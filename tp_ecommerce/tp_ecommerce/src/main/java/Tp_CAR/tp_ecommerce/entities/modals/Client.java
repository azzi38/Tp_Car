package Tp_CAR.tp_ecommerce.entities.modals;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue
    private int idClient;
    
    private String nomClient;
    private String prenom ;
    private String adress;
    private String email;
    private String tel;
    private String password ;
    @OneToMany
    private Collection<Commande> commandes;


    public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Client(String nomClient,String prenom, String adress, String email, String tel,String password) {
        super();
        this.nomClient = nomClient;
        this.adress = adress;
        this.email = email;
        this.password = password ;
        this.tel = tel;
        this.commandes=new ArrayList<>();
    }
    public Client() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public String getNomClient() {
        return nomClient;
    }
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public Collection<Commande> getCommandes() {
        return commandes;
    }
    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }
    public void addCommande(Commande com) {
    	this.commandes.add(com);
    }



}
