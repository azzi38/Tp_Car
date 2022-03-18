package Tp_CAR.tp_ecommerce.Controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import Tp_CAR.tp_ecommerce.Repository.ProductRepository;
import Tp_CAR.tp_ecommerce.Repository.ClientRepository;
import Tp_CAR.tp_ecommerce.entities.modals.Basket;
import Tp_CAR.tp_ecommerce.entities.modals.Client;
import Tp_CAR.tp_ecommerce.entities.modals.Credential;
import Tp_CAR.tp_ecommerce.entities.modals.Product;

@Controller
public class LoginController {
	@Autowired 
	ClientRepository clientRepository ;
	@Autowired 
	ProductRepository productRepository ;
	@RequestMapping(value="/addClient", method = RequestMethod.POST)	
	public ModelAndView addClient(Client client) {
		clientRepository.save(client);
		ModelAndView model = new ModelAndView("signin");
		return model;
	}
	@RequestMapping(value="/signin", method = RequestMethod.POST)	
	public ModelAndView signIn(Credential user,WebRequest request){
		List<Client> clients = clientRepository.findAll();
		if (clients.isEmpty()) {
			ModelAndView model = new ModelAndView("signinError");		
			return model;
		}
		for (Client cl : clients ) {
			if (cl.getEmail().equals(user.getEmail()) && cl.getPassword().equals(user.getPassword())){
				List<Product> liste = productRepository.findAll();
				request.setAttribute("loggedIn", true, WebRequest.SCOPE_SESSION);
				request.setAttribute("user", cl, WebRequest.SCOPE_SESSION);
				request.setAttribute("basket", new Basket(cl,new ArrayList<Product>()), WebRequest.SCOPE_SESSION);
				ModelAndView model = new ModelAndView("productAfterLogin");
					model.addObject("prods",liste);
					return model;
				}
			
			else {
				ModelAndView model = new ModelAndView("signinError");		
				return model;
			}
			}
		return null;	
	

}
	@GetMapping("/login")	
	public ModelAndView logIn() {
	
		List<Product> liste = productRepository.findAll();
		ModelAndView model = new ModelAndView("login");		
		return model;
		
	}
	@GetMapping("/logout")	
	public ModelAndView logOut(WebRequest request) {
		request.setAttribute("loggedIn", false, WebRequest.SCOPE_SESSION);
		request.removeAttribute("user",  WebRequest.SCOPE_SESSION);
		List<Product> liste = productRepository.findAll();
		ModelAndView model = new ModelAndView("product");	
		model.addObject("prods",liste);
		return model;
		
	}
	@GetMapping("/signinForm")	
	public ModelAndView signInForm() {
	
		ModelAndView model = new ModelAndView("signin");		
		return model;
		
	}
}
