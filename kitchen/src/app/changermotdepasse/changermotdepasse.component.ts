import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/kitchenStory-api/src/models';
import { CustomersService } from 'src/kitchenStory-api/src/services';


@Component({
  selector: 'app-changermotdepasse',
  templateUrl: './changermotdepasse.component.html',
  styleUrls: ['./changermotdepasse.component.scss']
})
export class ChangermotdepasseComponent implements OnInit {
user:Customer={};
email:string=""
newPassword=""

params={

  body:{},
  email:this.email,
  newPassword:this.newPassword
}


  constructor(private customerService:CustomersService,private router:Router) { 
    
  }

  ngOnInit(): void {
    
  }
 save(){
    this.customerService.updatePassword(this.params).subscribe(res =>{
this.user=res;


    })
    this.router.navigate(['/products']);
  
   
  


  }
  

}
