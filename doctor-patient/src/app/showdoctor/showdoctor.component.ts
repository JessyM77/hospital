import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Doctor } from '../doctorModel';



@Component({
  selector: 'app-showdoctor',
  templateUrl: './showdoctor.component.html',
  styleUrls: ['./showdoctor.component.css']
})
export class ShowdoctorComponent implements OnInit {

  doctors! : Doctor[];
  name! : string;
  showTable : boolean = false;
  selectedValue: string = '';
  doctorList : any;

  constructor(private service: DoctorService) { }

  ngOnInit(): void {
    this.service.getAllDoctors().subscribe((res) =>{
      this.doctorList=res;
    })

    this.doctors = this.doctorList;
    this.getDoctor();
  }

  getDoctor()
  { 
    this.service.findDoctorByName(this.selectedValue)
    .subscribe((res) => {
      this.doctors = res
    })
  }
  onSelect(event : any)
  {
    this.selectedValue = event.target.value;
    this.getDoctor();
    this.showTable = true;
  }
}
