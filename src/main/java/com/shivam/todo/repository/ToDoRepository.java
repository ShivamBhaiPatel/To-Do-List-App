package com.shivam.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.todo.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer>{

}
