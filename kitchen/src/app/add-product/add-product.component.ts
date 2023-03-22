import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/kitchenStory-api/src/models/product';
import { ProductsService } from 'src/kitchenStory-api/src/services/products.service';




@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {
  product:Product={}


  constructor(private productService:ProductsService,private router:Router) { }

  ngOnInit(): void {
  }
  add(){
    this.productService.save(this.product).subscribe(res =>{
this.product=res;

this.router.navigate(['/products'])


  })
  
}


}
