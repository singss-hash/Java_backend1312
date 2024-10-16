 import { ActivatedRoute, ActivatedRouteSnapshot, ResolveFn, RouterStateSnapshot } from "@angular/router";
import { EmployeeService } from "./employee.service";
import { Observable, of } from "rxjs";
import { inject } from "@angular/core";
import { Employee } from "./employee.model";
 export const EmployeeResolver: ResolveFn<any> =
 (route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot,
    employeeService: EmployeeService= inject(EmployeeService)) :Observable<Employee>=> {
        

        const userId = route.paramMap.get("userId");
        if(userId) {
            //make api call and get data for given employee id
            return employeeService.getEmployee(Number(userId));
        }
        else {

          const employee:  Employee={

            userId: 0,
            name: '',
            emailId: '',
            departmentName:'',
            projectName: '',
            designation: '',
          }

          return of(employee);
            // password: '@123'
          };

        }
    