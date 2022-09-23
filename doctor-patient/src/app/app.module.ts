import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DoctorComponent } from './doctor/doctor.component';
import { PatientComponent } from './patient/patient.component';
import { HomeComponent } from './home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { DoctorService } from './doctor.service';
import { PatientService } from './patient.service';
import { ShowdoctorComponent } from './showdoctor/showdoctor.component';
import { ShowpatientComponent } from './showpatient/showpatient.component';


@NgModule({
  declarations: [
    AppComponent,
    DoctorComponent,
    PatientComponent,
    HomeComponent,
    ShowdoctorComponent,
    ShowpatientComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [DoctorService, PatientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
