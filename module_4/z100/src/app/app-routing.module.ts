import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {WelcomeComponent} from "./components/welcome/welcome.component";

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'welcome'},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'home', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
