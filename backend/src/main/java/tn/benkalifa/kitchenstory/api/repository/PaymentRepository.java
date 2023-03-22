package tn.benkalifa.kitchenstory.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.benkalifa.kitchenstory.api.model.Payment;

@Repository
public interface  PaymentRepository extends JpaRepository< Payment, Integer> {
	

}
