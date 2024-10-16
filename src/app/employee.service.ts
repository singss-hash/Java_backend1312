import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from './employee.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpClient: HttpClient) {}

     api="http://localhost:8080"

    public saveEmployee(employee: Employee): Observable<Employee>{
      return this.httpClient.post<Employee>(`${this.api}/api/users/user`, employee);
    }

    public getEmployees(): Observable<Employee[]> {
      return this.httpClient.get<Employee[]>(`${this.api}/api/users`);
    }
    public deleteEmployee(userId: number) {
      return this.httpClient.delete(`${this.api}/api/users/${userId}`);
    }


    public getEmployee(userId: number) {
      return this.httpClient.get<Employee>(`${this.api}/api/users/${userId}`);
    }

    public updateEmployee(employee: Employee) {
      return this.httpClient.put<Employee>(`${this.api}/api/users/`,employee);
    }

   }

