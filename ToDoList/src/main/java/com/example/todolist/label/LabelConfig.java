package com.example.todolist.label;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LabelConfig {
    /*@Bean
    CommandLineRunner commandLineRunner(LabelRepository labelRepository){
        return args -> {
            Label label1 = new Label(
                    "Housekeeping",
                    "Blue"
            );
            Label label2 = new Label(
                    "School work",
                    "baby pink"
            );

            labelRepository.saveAll(List.of(label1,label2));
        };
    }*/
}
