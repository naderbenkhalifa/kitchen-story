import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Customer } from 'src/kitchenStory-api/src/models/customer';
import { Payment } from 'src/kitchenStory-api/src/models/payment';
import { Purchase } from 'src/kitchenStory-api/src/models/purchase';
import { PurchaseItem } from 'src/kitchenStory-api/src/models/purchase-item';
import { CustomersService } from 'src/kitchenStory-api/src/services/customers.service';
import { PurchasesService } from 'src/kitchenStory-api/src/services/purchases.service';



import { CartItem } from '../cart-item';
import { ChariotService } from '../chariot.service';

@Component({
  selector: 'app-paymentsuccessful',
  templateUrl: './paymentsuccessful.component.html',
  styleUrls: ['./paymentsuccessful.component.scss']
})
export class PaymentsuccessfulComponent implements OnInit {
  payment:Payment={}
  totalPrice:number=0;
  totalAmount:number=0;
  cartItems: CartItem[]=[]
  totalQuantity=0;
  user:Customer={}
    
  newPurchase: any;


  constructor(public service:ChariotService,private router:Router,private purchaseService :PurchasesService,private customerService:CustomersService) { 
    this.totalPrice=this.service. getTotalPrice();
    this.totalQuantity=this.service.getTotalQuantity();
    let currentDate = new Date();
    this.payment.dateOfPayment=currentDate.toISOString();
   

  }

  ngOnInit(): void {
    this.cartItems = this.service.cartItems;
    
  }
  purchase(){
    let newPurchase:Purchase={};
  // newPurchase.customer=this.user;

     let currentDate = new Date();
    newPurchase.dateOfPurchase=currentDate.toISOString();
    newPurchase.totalcost=this.totalPrice;
    
    newPurchase.purchaseItems=[];
    for(let p of this.cartItems){
      let purchaseItem: PurchaseItem ={};
      purchaseItem.product=p;
      
    
      purchaseItem.quantity=p.quantity;
      newPurchase.purchaseItems.push(purchaseItem)
      
    }
    this.purchaseService.save(newPurchase).subscribe(res =>{
      this.newPurchase=res;
     
      this.totalPrice=this.service. getTotalPrice();
     
    });
  
 
    this. resetCart();
    this.router.navigate(['/chariot']);


  }
 
 
  resetCart() {
    
    this.service.cartItems = [];
    this.service.totalPrice.next(0);
    this.service.totalQuantity.next(0);
    
  
 
  }
 

}
