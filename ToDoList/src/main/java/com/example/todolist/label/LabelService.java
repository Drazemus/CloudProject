package com.example.todolist.label;

import com.example.todolist.task.Task;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LabelService {
    private final LabelRepository labelRepository;

    @Autowired
    public LabelService(LabelRepository labelRepository){this.labelRepository=labelRepository;}

    public List<Label> getLabels(){return labelRepository.findAll();}

    public void addNewLabel(Label label) {
        Optional<Label> labelOptional = labelRepository.findLabelByName(label.getName());
        if (labelOptional.isPresent()){
            throw new IllegalStateException("Label already exist");
        }
        labelRepository.save(label);
    }

    public void deleteLabel(Long labelId) {
        boolean exists = labelRepository.existsById(labelId);
        if (!exists){
            throw new IllegalStateException("Label with Id : "+labelId+" does not exist");
        }
        labelRepository.deleteById(labelId);
    }

    @Transactional
    public void updateLabel(Long labelId, String name, String color) {
        Label label = labelRepository.findById(labelId).orElseThrow(() -> new IllegalStateException(
                "Label with id : "+labelId+" does not exist"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(label.getName(),name)){
            Optional<Label> labelOptional = labelRepository.findLabelByName(name);
            if (labelOptional.isPresent()){
                throw new IllegalStateException("Label already exist");
            }
            label.setName(name);
        }

        if (color != null && color.length() > 0 && !Objects.equals(label.getColor(),color)){
            label.setColor(color);
        }
    }
}
