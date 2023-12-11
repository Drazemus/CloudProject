package com.example.todolist.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner(TaskRepository taskRepository){
        return args -> {
            Task task1 = new Task(
                    "Do the cloud project",
                    LocalDate.of(2023, Month.DECEMBER,15)
            );

            taskRepository.save(task1);
        };
    }
}
