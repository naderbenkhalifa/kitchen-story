import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/kitchenStory-api/src/models/customer';
import { CustomersService } from 'src/kitchenStory-api/src/services/customers.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
user:Customer={};
message="";
  constructor(private customerService:CustomersService,private router:Router) { }

  ngOnInit(): void {
  }
  public signIn():void {
    this.customerService.addUserLogin(this.user).subscribe(res=>{
     
      this.user=res;
      this.router.navigate(['/products']);
    
     
       

     },
     error => {
      
      this.message=" email or password is incorrect. "
      });
    
      
 

  }

}
