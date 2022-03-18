package Tp_CAR.tp_ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import Tp_CAR.tp_ecommerce.entities.modals.Product;
import Tp_CAR.tp_ecommerce.Repository.ProductRepository;
@SpringBootApplication
public class TpEcommerceApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TpEcommerceApplication.class, args);
		ProductRepository productRepository = ctx.getBean(ProductRepository.class);
		productRepository.save(new Product("carte mere","Compatible avec les processeurs AMD Ryzen sur socket AMD AM4 ",5,59));
		productRepository.save(new Product("ssd nvme","500GO 2400Mo/s ",5,47));
		productRepository.save(new Product("carte son","Canaux de sortie audio: 7.1 canaux",5,78));
		productRepository.save(new Product("carte graphique","6 Go GDDR6 - HDMI/Tri DisplayPort",5,250));
	
	
	}

}
