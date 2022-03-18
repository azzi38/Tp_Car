package Tp_CAR.tp_ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tp_CAR.tp_ecommerce.Repository.ProductRepository;
import Tp_CAR.tp_ecommerce.entities.modals.Product;

@RestController
@Service
public class ProductRestService {
@Autowired 
private ProductRepository productRepository ;
@RequestMapping(value="/saveProduct")
public Product addProduct(Product p) {
	return productRepository.save(p);
}
@RequestMapping(value="/getProductById")
public Product getProductById(int id) {
	return productRepository.getOne(id);
}
@RequestMapping(value="/AllProducts")
public List<Product> getAllProducts(){
	return productRepository.findAll();
}
}
