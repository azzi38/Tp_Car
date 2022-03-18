package Tp_CAR.tp_ecommerce.Controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import Tp_CAR.tp_ecommerce.Repository.CommandeRepository;
import Tp_CAR.tp_ecommerce.Repository.ClientRepository;
import Tp_CAR.tp_ecommerce.Repository.ProductRepository;
import Tp_CAR.tp_ecommerce.entities.modals.Basket;
import Tp_CAR.tp_ecommerce.entities.modals.Client;
import Tp_CAR.tp_ecommerce.entities.modals.Commande;
import Tp_CAR.tp_ecommerce.entities.modals.Product;

@Controller
public class CartController {
	@Autowired 
	ClientRepository clientRepository ;
	@Autowired 
	ProductRepository productRepository ;
	@Autowired
	CommandeRepository commandeRepository;
	@RequestMapping(value="/addToCart/{idProduct}", method = RequestMethod.GET)	
	public ModelAndView addToCart(@PathVariable int idProduct,WebRequest request) {
		
		Optional<Product> prod = productRepository.findById(idProduct);
		List<Product> liste = productRepository.findAll();
		Basket basket = (Basket) request.getAttribute("basket", WebRequest.SCOPE_SESSION);
		basket.addProduct(prod.get());
		request.removeAttribute("basket", WebRequest.SCOPE_SESSION);
		request.setAttribute("basket", basket, WebRequest.SCOPE_SESSION);
		ModelAndView model = new ModelAndView("productAfterLogin");
		model.addObject("prods",liste);
		return model;
	}
	@RequestMapping(value="/cart")
	public ModelAndView showCart(WebRequest request) {
		Basket basket = (Basket) request.getAttribute("basket", WebRequest.SCOPE_SESSION);
		Collection<Product> liste = basket.getProducts();
		int prixTotal = 0;
		for (Product prod :liste) {
			prixTotal+=prod.getPrix();
		}
		ModelAndView model = new ModelAndView("Cart");
		model.addObject("prods",liste);
		model.addObject("total",prixTotal);
		return model;		
	}
	@RequestMapping(value="/remove/{idProduct}", method = RequestMethod.GET)	
	public ModelAndView remove(@PathVariable int idProduct,WebRequest request) {
		Basket basket = (Basket) request.getAttribute("basket", WebRequest.SCOPE_SESSION);
		Collection<Product> liste = basket.getProducts();
		
		liste.removeIf(s -> s.idProduct==idProduct);
		
		basket.setProducts(liste);
		int prixTotal = 0;
		for (Product prod :liste) {
			prixTotal+=prod.getPrix();
		}
		request.removeAttribute("basket", WebRequest.SCOPE_SESSION);
		request.setAttribute("basket", basket, WebRequest.SCOPE_SESSION);
		ModelAndView model = new ModelAndView("Cart");
		model.addObject("prods",liste);
		model.addObject("total",prixTotal);
		return model;
			
	}
	@RequestMapping(value="/continue", method = RequestMethod.GET)
	public ModelAndView Continue(WebRequest request) {
		List<Product> liste = productRepository.findAll();
		ModelAndView model = new ModelAndView("productAfterLogin");
		model.addObject("prods",liste);
		return model;
		
	}
	@RequestMapping(value="/valider", method = RequestMethod.GET)
	public ModelAndView Valider(WebRequest request) {
		Basket basket = (Basket) request.getAttribute("basket", WebRequest.SCOPE_SESSION);
		Collection<Product> liste = basket.getProducts();
		liste.removeIf(s -> s.getQuantity()==0);
		for(Product prod : liste){
			prod.setQuantity(prod.getQuantity()-1);
			productRepository.save(prod);
		}
		Client client = (Client) request.getAttribute("user", WebRequest.SCOPE_SESSION);
		Commande commande = new Commande(liste,client);		
		commandeRepository.save(commande);
		client.addCommande(commande);
		request.removeAttribute("basket", WebRequest.SCOPE_SESSION);
		request.setAttribute("basket", new Basket(client,new ArrayList<Product>()), WebRequest.SCOPE_SESSION);
		request.removeAttribute("user", WebRequest.SCOPE_SESSION);
		request.setAttribute("user", client, WebRequest.SCOPE_SESSION);
		//clientRepository.save(client);
		ModelAndView model = new ModelAndView("validation");		
		return model;
	}
	}
