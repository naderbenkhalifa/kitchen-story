package tn.benkalifa.kitchenstory.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.benkalifa.kitchenstory.api.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase,Long>{

}
