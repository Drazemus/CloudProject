package com.example.todolist.task;

import com.example.todolist.label.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping
    public void registerNewTask(@RequestBody Task task){taskService.addNewTask(task);}

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId")Long taskId){
        taskService.deleteTask(taskId);
    }

    @PutMapping(path = "taskId")
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) LocalDate deadline){
        taskService.updateTask(taskId,name,deadline);
    }


}
