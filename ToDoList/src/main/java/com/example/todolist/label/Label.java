package com.example.todolist.label;

import jakarta.persistence.*;

@Entity
@Table
public class Label {
    @Id
    @SequenceGenerator(
            name = "label_sequence",
            sequenceName = "label_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "label_sequence"
    )
    private long id;
    private String name;
    private String color;

    public Label(long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Label(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Label() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
