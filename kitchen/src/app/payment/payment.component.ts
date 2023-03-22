import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Payment } from 'src/kitchenStory-api/src/models';
import { PaymentsService } from 'src/kitchenStory-api/src/services';

import { CartItem } from '../cart-item';
import { ChariotService } from '../chariot.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {
 
  payment:Payment={}
  totalPrice:number=0;
  totalAmount:number=0;
  cartItems: CartItem[]=[]
  totalQuantity=0
  constructor(public service:ChariotService,private router:Router ,public paymentService: PaymentsService) { 
    this.totalPrice=this.service. getTotalPrice();
    this.totalQuantity=this.service.getTotalQuantity();
    let currentDate = new Date();
    this.payment.dateOfPayment=currentDate.toISOString();
    this.payment.totalAmount=this.totalPrice;
   

      
    
  }

  ngOnInit(): void {
    this.listCartDetails();
    
}
  public  pay(){
    this.paymentService.save(this.payment).subscribe(res=>{
    this.payment=res;
   
  

    })
    this.router.navigate(['/paymentsuccessful']);
  
  }

  cancel(){
    this.router.navigate(['/chariot']);

  }
  listCartDetails() {

    this.cartItems = this.service.cartItems;
    
   this.service.totalPrice.subscribe(
       data => this.totalPrice = data
     );
 
   
     this.service.totalQuantity.subscribe( 
       data => this.totalQuantity = data
     );
 
     
     this.service.computeCartTotals();
   }


   
  

}
