import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { VoitureDetailComponent } from './voiture-detail/voiture-detail.component';
import { ProfilComponent } from './profil/profil.component';
import { AjouterVoitureComponent } from './ajouter-voiture/ajouter-voiture.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'voiture-detail/:id', component: VoitureDetailComponent },
  { path: 'profil/:id', component: ProfilComponent },
  { path: 'profil', component: ProfilComponent },
  { path: 'ajouter-voiture', component: AjouterVoitureComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent }
];
