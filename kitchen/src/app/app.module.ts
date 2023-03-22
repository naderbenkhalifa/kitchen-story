import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ProductsComponent } from './products/products.component';
import { ChariotComponent } from './chariot/chariot.component';

import { PaymentComponent } from './payment/payment.component';
import { PaymentsuccessfulComponent } from './paymentsuccessful/paymentsuccessful.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ChangermotdepasseComponent } from './changermotdepasse/changermotdepasse.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProductsComponent,
    ChariotComponent,
  
    PaymentComponent,
    PaymentsuccessfulComponent,
    AddProductComponent,
    ChangermotdepasseComponent,
    LoginComponent,
    RegisterComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
