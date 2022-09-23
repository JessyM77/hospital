import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DoctorService } from '../doctor.service';
import { PatientService } from '../patient.service';
import { Patient } from '../patientModel';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  formValue! : FormGroup;
  patientObj : Patient = new Patient();
  patientData : any;
  submitted : boolean = false;

  doctorList : any;

  constructor(private fb : FormBuilder, private service : PatientService,
    private api:DoctorService) { }
  get f (){return this.formValue.controls}

  ngOnInit(): void {

    this.formValue = this.fb.group({
      name:[''],
      age: [''],
      visitedDoctorName: [''],
      dateOfVisit : [''],
      prescription : [''],
      dId : ['']
    })

    this.getAllPatients();

    this.api.getAllDoctors().subscribe((res) =>{
      this.doctorList=res;
    })

   
  }


  onsubmit(){
    this.submitted = true;
    if(this.formValue.invalid){
      return;
    }
  }

  onselect(){
    this.patientObj.visitedDoctorName = this.doctorList.name;
   
  }
  postPatientDetails()
  {
    this.patientObj.name = this.formValue.value.name;
    this.patientObj.age = this.formValue.value.age;
    this.patientObj.visitedDoctorName = this.formValue.value.visitedDoctorName;
    this.patientObj.dateOfVisit = this.formValue.value.dateOfVisit;
    this.patientObj.prescription = this.formValue.value.prescription;
    this.patientObj.dId = this.formValue.value.dId;

    this.service.createPatient(this.patientObj)
    .subscribe((res) =>{
      console.log(res);
      alert("Patient details posted successfully")
      let ref = document.getElementById('cancel')
      ref?.click();
      this.formValue.reset();
      this.getAllPatients();
    },
      (err) => {
      alert("something went wrong");
    })

  }

  getAllPatients()
  {
    this.service.findAllPatients().subscribe((res)=>{
      this.patientData = res;
    })
  }

}
