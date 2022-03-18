package Tp_CAR.tp_ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Tp_CAR.tp_ecommerce.entities.modals.Commande;


	@Repository
	public interface CommandeRepository extends JpaRepository<Commande,Integer>{}
