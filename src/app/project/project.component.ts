import { Component, OnInit } from '@angular/core';
import { Project } from '../project/project.model';
import { NgForm } from '@angular/forms';
import { ProjectService } from '../Services/project.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { ThisReceiver } from '@angular/compiler';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
  project: Project = {
    projectId: 0,
    projectName: '',
    departmentID: 0,
    departmentName: '',
    description: '',
    client: ''
  }
  constructor(private projectService: ProjectService) {


  }
  ngOnInit(): void {

    throw new Error('Method not implemented.');
  }
  saveProject(projectForm: NgForm):void {

this.projectService.saveProject(this.project).subscribe(
  {
    next: (res: Project)=> {
      console.log(res);
      projectForm.reset();
    },
    error: (err: HttpErrorResponse)=> {
      console.log(err);
    }
  }
);
  }

}
