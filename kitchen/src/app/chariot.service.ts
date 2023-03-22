import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { Subject } from 'rxjs/internal/Subject';
import { CartItem } from './cart-item';

@Injectable({
  providedIn: 'root'
})
export class ChariotService {
  cartItems: CartItem[] = [];
  public productList = new BehaviorSubject<any>([]);

  totalPrice: Subject<number> = new Subject<number>();
  totalQuantity: Subject<number> = new Subject<number>();

  constructor() { }
  addToCart(theCartItem: CartItem) {

   
    let alreadyExistsInCart: boolean = false;
    let existingCartItem:  any;

    if (this.cartItems.length > 0) {
     

      existingCartItem= this.cartItems.find( tempCartItem => tempCartItem.id === theCartItem.id );

    
      alreadyExistsInCart = (existingCartItem != undefined);
    }

    if (alreadyExistsInCart) {
     
      existingCartItem.quantity++;
    }
    else {
      
      this.cartItems.push(theCartItem);
    }

   
    this.computeCartTotals();
  }
  computeCartTotals() {

    let totalPriceValue: number = 0;
    let totalQuantityValue: number = 0;

    for (let currentCartItem of this.cartItems) {
      totalPriceValue += currentCartItem.quantity * currentCartItem.price!;
      totalQuantityValue += currentCartItem.quantity;
    }

   
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);
    
     this.logCartData(totalPriceValue, totalQuantityValue);

    }
    logCartData(totalPriceValue: number, totalQuantityValue: number) {

      console.log('Contents of the cart');
      for (let tempCartItem of this.cartItems) {
        const subTotalPrice = tempCartItem.quantity * tempCartItem.price!;
        console.log(`name: ${tempCartItem.name}, quantity=${tempCartItem.quantity}, unitPrice=${tempCartItem.price}, subTotalPrice=${subTotalPrice}`);
      }
  
      console.log(`totalPrice: ${totalPriceValue.toFixed(2)}, totalQuantity: ${totalQuantityValue}`);
      console.log('----');
    }
    decrementQuantity(theCartItem: CartItem) {

      theCartItem.quantity--;
  
      if (theCartItem.quantity === 0) {
        this.remove(theCartItem);
      }
      else {
        this.computeCartTotals();
      }
    }
    remove(theCartItem: CartItem) {

    
      const itemIndex = this.cartItems.findIndex( tempCartItem => tempCartItem.id === theCartItem.id );
  
      if (itemIndex > -1) {
        this.cartItems.splice(itemIndex, 1);
  
        this.computeCartTotals();
      }
    }
    
    getTotalPrice() :number{
   
      let grandTotal = 0;
      this.cartItems.map((a:CartItem)=>{
        grandTotal += (a.quantity)*(a.price);
      })
      return grandTotal;
    }
    getTotalQuantity() :number{
   
      let grandTotal = 0;
      this.cartItems.map((a:CartItem)=>{
        grandTotal += (a.quantity)
      })
      return grandTotal;
    }
}
