
package Tp_CAR.tp_ecommerce.Controller;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import Tp_CAR.tp_ecommerce.Repository.ClientRepository;
import Tp_CAR.tp_ecommerce.entities.modals.Client;
import Tp_CAR.tp_ecommerce.entities.modals.Commande;

@Controller
public class AccountController {
	@Autowired
	ClientRepository clientRepository ;
	@GetMapping("/account")	
	public ModelAndView account(WebRequest request) {
		ModelAndView model = new ModelAndView("account");
		Client client = (Client) request.getAttribute("user", WebRequest.SCOPE_SESSION);
		Collection<Commande> commandes = client.getCommandes();
		model.addObject("commandes",commandes);
		return model;
		
	}
}
