package com.example.todolist.label;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/label")
public class LabelController {
    private final LabelService labelService;

    @Autowired
    public LabelController(LabelService labelService){this.labelService=labelService;}

    @GetMapping
    public List<Label> getLabels(){return labelService.getLabels();}

    @PostMapping
    public void registerNewLabel(@RequestBody Label label){
        labelService.addNewLabel(label);
    }

    @DeleteMapping(path = "{labelId}")
    public void deleteLabel(@PathVariable("labelId")Long labelId){
        labelService.deleteLabel(labelId);
    }

    @PutMapping(path = "labelId")
    public void updateTask(
            @PathVariable("labelId") Long labelId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color){
        labelService.updateLabel(labelId,name,color);
    }
}
