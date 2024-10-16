import { afterNextRender, Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { NgForm } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  isCreateEmployee : boolean = false;
  employee: any;
    
   
constructor(private employeeService: EmployeeService,
  private router: Router,
private activatedRoute : ActivatedRoute) {

}
  ngOnInit(): void {
   this.employee= this.activatedRoute.snapshot.data['employee'];
   console.log(this.employee);
   if(this.employee && this.employee.emailId>0)
 {
  this.isCreateEmployee = false;

 } 
else {
  this.isCreateEmployee = true;
} 
}
  saveEmployee(employeeForm:NgForm):void{

    if(this.isCreateEmployee) {
 this.employeeService.saveEmployee(this.employee).subscribe(
  {
   
        next: (res: Employee) => {
          console.log(res);
          employeeForm.reset();
          this.router.navigate(["/employee-list"]);
        },
        error: (err: HttpErrorResponse)=> {
          console.log(err);
        }
  }
 );
    } else {
      this.employeeService.updateEmployee(this.employee).subscribe

{
next: (res: Employee) => {
  this.router.navigate(["/employee-list"]);
}
  error: (err: HttpErrorResponse) => {
    console.log(err);
  }

}
    }

  }
}

  