import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PurchasesService } from 'src/kitchenStory-api/src/services';


import { CartItem } from '../cart-item';
import { ChariotService } from '../chariot.service';

@Component({
  selector: 'app-chariot',
  templateUrl: './chariot.component.html',
  styleUrls: ['./chariot.component.scss']
})
export class ChariotComponent implements OnInit {
  cartItems: CartItem[] = [];
  totalPrice: number = 0;
  totalQuantity: number = 0;
  user:any;
  
  

  newPurchase: any;

  constructor(private service: ChariotService,private router :Router,private purchaseService :PurchasesService) {
    
   }

  ngOnInit(): void {
    this.listCartDetails();
    
   
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
  incrementQuantity(theCartItem: CartItem) {
    this.service.addToCart(theCartItem);
  }
  decrementQuantity(theCartItem: CartItem) {
    this.service.decrementQuantity(theCartItem);
  }
  remove(theCartItem: CartItem) {
    this.service.remove(theCartItem);
  }
 
   
    
   
  resetCart(){
    this.service.cartItems = [];
    this.service.totalPrice.next(0);
    this.service.totalQuantity.next(0);
    this.listCartDetails();
  
 }
  checkout(){
    this.router.navigate(['/payment'])
  }
  navigate(){
    this.router.navigate(['/products'])
  }





}
