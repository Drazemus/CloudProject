package com.example.todolist.task;

import com.example.todolist.label.Label;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Objects;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public void addNewTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if (!exists){
            throw new IllegalStateException("Task with Id : "+taskId+" does not exist");
        }
        taskRepository.deleteById(taskId);
    }

    @Transactional
    public void updateTask(Long taskId, String name, LocalDate deadline) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalStateException(
                "Task with id : "+taskId+" does not exist"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(task.getName(),name)){
            task.setName(name);
        }

        if (deadline != null && !Objects.equals(task.getDeadline(),deadline)){
            task.setDeadline(deadline);
        }
    }
}
