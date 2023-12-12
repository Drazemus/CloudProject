import { Component, OnInit } from '@angular/core';
import { Task } from './task';
import { TaskService } from './task.service';
import { response } from 'express';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'ToDoListApp';
  public tasks: Task[] = [];
  public task: Task = this.tasks[0];

  constructor(private taskservice: TaskService){}

  ngOnInit() {
    this.getTasks();
  }

  public getTasks(): void {
    this.taskservice.getTasks().subscribe(
      (response: Task[]) => {
        this.tasks = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public onAddEmloyee(addForm: NgForm): void {
    console.log(addForm.value);
    document.getElementById('addTask')!.click();
    this.taskservice.addTask(addForm.value).subscribe(
      (response: Task) => {
        console.log(response);
        this.getTasks();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onDeleteTask(taskId: number): void {
    this.taskservice.DeleteTask(taskId).subscribe(
      (response: void) => {
        console.log(response);
        this.getTasks();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


}
