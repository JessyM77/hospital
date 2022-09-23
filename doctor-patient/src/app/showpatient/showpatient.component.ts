import { Component, OnInit } from '@angular/core';
import { PatientService } from '../patient.service';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { Patient } from '../patientModel';

@Component({
  selector: 'app-showpatient',
  templateUrl: './showpatient.component.html',
  styleUrls: ['./showpatient.component.css']
})
export class ShowpatientComponent implements OnInit {

  searchValue! : number;
  patients! : Patient[];
  showTable : boolean = false;

  patientList: any;

  constructor(private service : PatientService) { }

  ngOnInit(): void {

    this.service.findAllPatients()
    .subscribe((res) =>{
      this.patientList = res;
    })
    this.patients = this.patientList;
    this.getPatient();
  }

  getPatient(){
    this.service.findPatientById(this.searchValue)
    .subscribe((res) => {
      this.patients = res
      console.log(res);
    })
  }

  onEnter(event : any)
  {
    this.searchValue = event.target.value;
    this.getPatient();
    this.showTable = true;
  }

}
