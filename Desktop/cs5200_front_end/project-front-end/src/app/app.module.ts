import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from "@angular/forms";

import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import {routing} from "./app.routing";
import { NavbarComponent } from './navbar/navbar.component';
import { PantryComponent } from './pantry/pantry.component';
import { RecipeComponent } from './recipe/recipe.component';
import {PersonServiceClient} from "./services/person.service.client";

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ProfileComponent,
    RegisterComponent,
    LoginComponent,
    NavbarComponent,
    PantryComponent,
    RecipeComponent
  ],
  imports: [
    BrowserModule,
    routing,
    FormsModule

  ],
  providers: [
    PersonServiceClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
