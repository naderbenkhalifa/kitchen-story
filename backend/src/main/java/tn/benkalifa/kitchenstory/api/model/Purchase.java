package tn.benkalifa.kitchenstory.api.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private float totalcost;
	private Date dateOfPurchase;
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "purchase_id")
	private List<PurchaseItem> purchaseItems;
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(float totalcost) {
		this.totalcost = totalcost;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public List<PurchaseItem> getPurchaseItems() {
		return purchaseItems;
	}
	public void setPurchaseItems(List<PurchaseItem> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
