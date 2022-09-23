import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorComponent } from './doctor/doctor.component';
import { HomeComponent } from './home/home.component';
import { PatientComponent } from './patient/patient.component';
import { ShowpatientComponent } from './showpatient/showpatient.component';
import { ShowdoctorComponent } from './showdoctor/showdoctor.component';

const routes: Routes = [
  {path: "", redirectTo: "home", pathMatch: "full"},
  {path: "home", component: HomeComponent},
  {path: "doctor", component: DoctorComponent},
  {path: "patient", component: PatientComponent},
  {path: "showdoctor", component: ShowdoctorComponent},
  {path: "showpatient", component: ShowpatientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
