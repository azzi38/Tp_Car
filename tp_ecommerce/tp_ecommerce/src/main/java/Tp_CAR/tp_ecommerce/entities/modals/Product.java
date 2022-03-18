package Tp_CAR.tp_ecommerce.entities.modals;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Product implements Serializable {
	/**
	 * 
	 */
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int idProduct ;
	private String nomProduit ;
	private String Description ;
	private int Quantity ;
	private int Prix ;
	public Product() {
		super();
	}
	public Product( String nomProduit, String description, int quantity, int prix) {
		super();
		this.idProduct = idProduct;
		this.nomProduit = nomProduit;
		this.Description = description;
		this.Quantity = quantity;
		Prix = prix;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	/**
	 * 
	 */
	
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getPrix() {
		return Prix;
	}
	public void setPrix(int prix) {
		Prix = prix;
	}  
}
