

import { Component, OnInit } from '@angular/core';
import { ChariotService } from '../chariot.service';
import { CartItem } from '../cart-item';
import { Router } from '@angular/router';
import { Customer } from 'src/kitchenStory-api/src/models/customer';
import { ProductsService } from 'src/kitchenStory-api/src/services/products.service';
import { CustomersService } from 'src/kitchenStory-api/src/services/customers.service';
import { Product } from 'src/kitchenStory-api/src/models/product';




@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
cartItems:CartItem[]=[]
  totalPrice=0
totalQuantity=0;
  products: Product[] = [];
  filteredProducts: Product[] = [];
  imageSource:string="\src\assets\images\img1";
  searchText:string="";
  login?:number;
 
  user:Customer={}
  constructor(private productService:ProductsService,
    private service :ChariotService,private router :Router,private customerService: CustomersService) {
    
      this.totalQuantity=this.service.getTotalQuantity();
     
     }

  ngOnInit(): void {
    this.getProducts();
    this.listCartDetails();
    
  }

  private getProducts(){
    this.productService.findAll().subscribe(data=>{
      this.products=data;
    })
  }

  
addToCart(product: Product) {
    
 
  const theCartItem = new CartItem(product);

  this.service.addToCart(theCartItem);
}
  filterProduct(event: any):void {

    if(this.searchText!='')
 this.products=this.products.filter(x => x.name?.includes( this.searchText));
 else {
   this.getProducts();
 }



  }

 
  
     
   
    delete(id:number):void{
      this.productService.delete(id).subscribe(res=>{
        this.getProducts();




      })
    }
    addProduct(){

      this.router.navigate(['/addProduct'])
     }
     public logout() {
   
      
      this.router.navigate(['/']);
     
      
     
        
      
  
    }
    navigate(){
      this.router.navigate(['/chariot'])
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
    change(){

      this.router.navigate(['/change'])
    }
   
   
   
      }
    
      
 

  
 

  


  
    

 



  

