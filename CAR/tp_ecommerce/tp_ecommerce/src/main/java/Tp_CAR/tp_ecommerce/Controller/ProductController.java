package Tp_CAR.tp_ecommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import Tp_CAR.tp_ecommerce.Repository.ProductRepository;
import Tp_CAR.tp_ecommerce.entities.modals.Product;

@Controller
public class ProductController {
	@Autowired 
	ProductRepository productRepository ;
	@GetMapping("/home")	
	public ModelAndView Get() {
	
		List<Product> liste = productRepository.findAll();
		ModelAndView model = new ModelAndView("product");
		model.addObject("prods",liste);
		return model;
		
	}
	
}
