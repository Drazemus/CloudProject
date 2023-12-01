package com.example.todolist.label;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<Label,Long> {

    //@Query("SELECT s FROM Label WHERE s.name = ?1")
    Optional<Label> findLabelByName(String name);
}
