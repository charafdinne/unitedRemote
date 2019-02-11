import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from './dashboard/dashboard.component';
import {PreferredShopsComponent} from './preferred-shops/preferred-shops.component';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  { path: 'myShops', component: PreferredShopsComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: 'login', component: LoginComponent}
]
@NgModule({
  imports: [ RouterModule.forRoot(routes)], // configure the router at the application's root level
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
