import { Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeResolver } from './employee-resolver';

import { LoginComponent} from './login/login.component';
import { ProjectComponent } from './project/project.component';
// import { ProjectListComponent } from './project-list/project-list.component';

export const routes: Routes = [
    {path: 'header', component: HeaderComponent},
    {path:'employee', component: EmployeeComponent,resolve: {employee: EmployeeResolver}},
    {path:'employee-list', component: EmployeeListComponent},
    {path: '',component: HomeComponent},
    {path:'login', component: LoginComponent},
    {path:'project',component: ProjectComponent}
    // {path:'project-list',component: ProjectListComponent}
  ];


