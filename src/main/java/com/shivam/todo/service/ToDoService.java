package com.shivam.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.todo.model.ToDo;
import com.shivam.todo.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository toDoRepo;
	
	public ToDo createToDo(ToDo toDo) {
		return toDoRepo.save(toDo);
	}
	
	public ToDo updateToDo(ToDo updatedToDo, int id) {
		return toDoRepo.findById(id).map(toDo -> {
			toDo.setTitle(updatedToDo.getTitle());
			toDo.setCompleted(updatedToDo.isCompleted());
			return toDoRepo.save(toDo);
		}).orElseThrow(() -> new RuntimeException("Task not found"));
	}
	
	public List<ToDo> getAllToDos(){
		return toDoRepo.findAll();
	}
	
	public ToDo getToDo(int id) {
		return toDoRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found."));
	}
	public void deleteToDO(int id) {
		toDoRepo.deleteById(id);
	}
	

}
