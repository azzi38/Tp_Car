package Tp_CAR.tp_ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tp_CAR.tp_ecommerce.Repository.ClientRepository;
import Tp_CAR.tp_ecommerce.Repository.ProductRepository;
import Tp_CAR.tp_ecommerce.entities.modals.Client;
import Tp_CAR.tp_ecommerce.entities.modals.Product;
@RestController
@Service
public class ClientRestService {
	
	
	@Autowired 
	private ClientRepository clientRepository ;
	@RequestMapping(value="/saveClient")
	public Client addClient(Client p) {
		return clientRepository.save(p);
	}
	@RequestMapping(value="/getClientByEmail")
	public Client getClientById(int id) {
		return clientRepository.getOne(id);
	}
	@RequestMapping(value="/AllClients")
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	}


