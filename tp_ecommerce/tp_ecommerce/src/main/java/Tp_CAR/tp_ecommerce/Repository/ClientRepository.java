package Tp_CAR.tp_ecommerce.Repository;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import Tp_CAR.tp_ecommerce.entities.modals.Client;

	@Repository
	public interface ClientRepository extends JpaRepository<Client,Integer>{
		 
	}


