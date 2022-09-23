import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { map } from 'rxjs/operators';
import { DoctorService } from '../doctor.service';
import { Doctor } from '../doctorModel';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  formValue! : FormGroup;
  doctorObj : Doctor = new Doctor();
  doctorData! : any;

  showAdd ! : boolean;
  showUpdate ! : boolean;

  submitted : boolean = false;

  constructor(private fb : FormBuilder, private service : DoctorService) { }
  get f (){return this.formValue.controls}

  ngOnInit(): void {

    this.formValue = this.fb.group({
      name : [''],
      gender : [''],
      age : [''],
      specialist : [''],
      no_Of_Patients : [''],
    })

    this.getAllDoctor();

  }

  clickCreateDoctor(){
    this.formValue.reset();
    this.showAdd = true;
    this.showUpdate = false;
  }

  onsubmit(){
    this.submitted = true;
    if(this.formValue.invalid){
      return;
    }
  }

  postDoctorDetails()
  {
    this.doctorObj.name = this.formValue.value.name;
    this.doctorObj.gender = this.formValue.value.gender;
    this.doctorObj.age = this.formValue.value.age;
    this.doctorObj.specialist = this.formValue.value.specialist;
    this.doctorObj.no_Of_Patients = this.formValue.value.no_Of_Patients;

    this.service.createDoctor(this.doctorObj)
    .subscribe((res) =>{
      console.log(res);
      alert("Doctor details posted successfully")
      let ref = document.getElementById('cancel')
      ref?.click();
      this.formValue.reset();
      this.getAllDoctor()
    },
      (err) => {
      alert("something went wrong");
    })
  }

  getAllDoctor(){
    this.service.getAllDoctors().subscribe((res)=>{
      this.doctorData = res;
    })
  }


}
