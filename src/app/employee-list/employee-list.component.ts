import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { EmployeeService } from '../employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  dataSource: Employee[]= [];
  displayedColumns: string[] = ['userId', 'name', 'emailId', 'departmentName','projectName','designation','edit','delete'];
  constructor(private employeeService: EmployeeService, 
    private router: Router) {
   
    this.getEmployeeList()

  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  updateEmployee(userId: number): void {
    this.router.navigate(['/employee',{userId: userId}]);


  }

  deleteEmployee(userId: number): void {
    console.log(userId);
    this.employeeService.deleteEmployee(userId).subscribe(
      {
        next: (res) => {
          console.log(res);
          this.getEmployeeList();
        },
        error: (err: HttpErrorResponse) => {
          console.log(err);
        }
      }

    )

    }

  
 getEmployeeList():void {
  this.employeeService.getEmployees().subscribe(
{ 
  next: (res: Employee[])=> {
  this.dataSource = res;
  },
  error: (err: HttpErrorResponse)=> {
    console.log(err);
  }
}
  );
 }
}
