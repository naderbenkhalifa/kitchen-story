package tn.benkalifa.kitchenstory.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.benkalifa.kitchenstory.api.model.PurchaseItem;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem,Long> {

}
