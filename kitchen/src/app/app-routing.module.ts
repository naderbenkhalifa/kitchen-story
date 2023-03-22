import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';
import { ChangermotdepasseComponent } from './changermotdepasse/changermotdepasse.component';
import { ChariotComponent } from './chariot/chariot.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { PaymentComponent } from './payment/payment.component';
import { PaymentsuccessfulComponent } from './paymentsuccessful/paymentsuccessful.component';
import { ProductsComponent } from './products/products.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
 
  {path: 'products',component : ProductsComponent },
  {path: '',component : LoginComponent },
  {path: 'header',component :HeaderComponent },
  {path: 'chariot',component :ChariotComponent },
  {path: 'payment',component :PaymentComponent },
  {path: 'paymentsuccessful',component :PaymentsuccessfulComponent },
  {path: 'addProduct',component :AddProductComponent },
  { path: 'change',component :ChangermotdepasseComponent},
  { path: 'register',component :RegisterComponent},
 
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
