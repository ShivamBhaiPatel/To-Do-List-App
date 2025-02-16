package com.shivam.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.todo.model.ToDo;
import com.shivam.todo.service.ToDoService;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	@PostMapping()
	public ResponseEntity<ToDo> createToDo(@RequestBody ToDo todo){
		return new ResponseEntity<ToDo>(toDoService.createToDo(todo), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo todo, @PathVariable Integer id){
		return new ResponseEntity<ToDo>(toDoService.updateToDo(todo, id), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ToDo> getToDo(@PathVariable Integer id){
		return new ResponseEntity<ToDo>(toDoService.getToDo(id), HttpStatus.OK);
	}
	@GetMapping()
	public ResponseEntity<List<ToDo>> getAllToDo(){
		return new ResponseEntity<List<ToDo>>(toDoService.getAllToDos(), HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteToDo(@PathVariable Integer id) {
		toDoService.deleteToDO(id);
		return new ResponseEntity<String>("Task deleted successfully", HttpStatus.OK);
	}

}
