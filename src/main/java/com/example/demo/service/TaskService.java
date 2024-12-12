package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {

	
	@Autowired
	TaskRepository repository;
	
	
	public List<Task> getAllTasks() {
		
		return repository.findAll();
	}


	public void CreateTask(String title) {
		
		Task task = new Task();
		
		task.setTitle(title);
		task.setCompleted(false);
		
		repository.save(task);
	}
	
	
	public void DeleteTask(Long id) {
		
		repository.deleteById(id);
	}


	public void toggleTask(Long id) {
		
		Task task = repository.findById(id).orElseThrow( () -> new IllegalArgumentException("Inavalid id"));
		
		task.setCompleted(!task.isCompleted());
	    repository.save(task);
	}

}
 