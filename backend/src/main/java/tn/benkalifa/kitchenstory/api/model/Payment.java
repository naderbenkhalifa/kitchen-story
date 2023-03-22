package tn.benkalifa.kitchenstory.api.model;





import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;






@Entity
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private Date dateOfPayment;
	
	@Column
	private float totalAmount;
	
	@Column
	private int cardNumber;
	
	@Column
	private String fullName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDateOfPayment() {
		return dateOfPayment ;
	}
	public void setDateOfPayment(Date dateOfPayment ) {
		this.dateOfPayment =dateOfPayment ;
	}
	public float getTotalAmount() {
		return totalAmount ;
	}
	public void setTotalAmount(float totalAmount ) {
		this. totalAmount =totalAmount ;
	}
	
	public int getCardNumber() {
		return cardNumber ;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getFullName() {
		return fullName ;
	}
	public void setFullName(String fullName ) {
		this.fullName =fullName ;
	}
	
	

}
