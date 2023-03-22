import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/kitchenStory-api/src/models/customer';
import { CustomersService } from 'src/kitchenStory-api/src/services/customers.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
user:Customer={}
  constructor(private customerService:CustomersService,private router:Router) { }

  ngOnInit(): void {
  }
  public signup() {
   
    this.customerService.save(this.user).subscribe(
      res=>{
        
         
          this.user=res;
        
          this.router.navigate(['/products']);
         
         

})
}
}
