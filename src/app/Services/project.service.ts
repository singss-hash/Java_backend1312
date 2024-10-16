import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../project/project.model';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private httpClient: HttpClient) { }
api="http://localhost:8080"

  public saveProject(project: Project): Observable<Project> {
    return this.httpClient.post<Project>(`${this.api}/api/projects/project`,project);
  }
}
