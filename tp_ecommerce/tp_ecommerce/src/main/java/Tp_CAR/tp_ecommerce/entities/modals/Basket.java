package Tp_CAR.tp_ecommerce.entities.modals;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
@Entity
public class Basket implements Serializable {
@Id @GeneratedValue
private Long Id ;
private Client client ;
@OneToMany
private Collection<Product> products;
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Collection<Product> getProducts() {
	return products;
}
public void setProducts(Collection<Product> products) {
	this.products = products;
}
public Basket() {
	super();
	
}
public Basket( Client client, Collection<Product> products) {
	super();
	this.client = client;
	this.products = products;
}
public void addProduct(Product p) {
	products.add(p);
}


}
