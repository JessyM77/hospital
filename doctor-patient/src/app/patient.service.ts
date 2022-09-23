import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) { }

  createPatient(data : any){
    return this.http.post<any>("http://localhost:9091/patient/save", data, {responseType : 'text' as 'json'})
    .pipe(map((res : any) =>{
      console.log(res)
    }))
  }

  findPatientById(id : number){
    return this.http.get("http://localhost:9091/patient/getById/" + id) 
    .pipe(map((res:any) => {
      return res;
    }))
  }

  findAllPatients(){
    return this.http.get<any>("http://localhost:9091/patient/get")
    .pipe(map((res:any) => {
      return res;
    }))
  }
}
