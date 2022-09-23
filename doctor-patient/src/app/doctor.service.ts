import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient) { }

  createDoctor(data : any)
  {
    return this.http.post<any>("http://localhost:9091/doctor/save", data, {responseType : 'text' as 'json'})
    .pipe(map((res:any)=>{
      return res;
    }))
  }

  findDoctorByName(name : string)
  {
    return this.http.get<any>("http://localhost:9091/doctor/getByName/" + name) 
    .pipe(map((res:any) => {
      return res;
    }))
  }

  getAllDoctors()
  {
    return this.http.get<any>("http://localhost:9091/doctor/get")
    .pipe(map((res:any) =>{
      return res;
    }))
  }
}
