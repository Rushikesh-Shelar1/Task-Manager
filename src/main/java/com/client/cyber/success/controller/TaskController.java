package com.client.cyber.success.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.client.cyber.success.dao.TaskServiceImpl;
import com.client.cyber.success.model.Task;
import com.client.cyber.success.service.TaskService;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
//	@Autowired
//	private TaskServiceImpl taskServiceImpl;
	
	@PostMapping("/")
	public Task createTask(@RequestBody Task task) {

		Task createTask= taskService.createTask(task);
		return createTask;
	}
	
	@PutMapping("/{taskId}")
	public String updateTask(@RequestBody Task task,@PathVariable int taskId) {
		int updateStatus=taskService.updateTask(task, taskId);
		if(updateStatus !=0) {
			return "<h2><font color='green'>Updated Succesfully</font></h2>";
			
		}
		else {
			return "<h2><font color='red'>not updated </font></h2>";
		}
	}
	
	@GetMapping("/fetchAllTask")
	public Page<Task> getAllTask(
			@RequestParam(value="pageNumber",defaultValue = "1",required=false)Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue = "10",required=false)Integer pageSize,
			@RequestParam(value="sortBy",defaultValue = "userId",required=false)String sortBy){
		return taskService.getAllTasks(pageNumber,pageSize,sortBy);
	}

	@DeleteMapping(path="/{taskId}")
	public String remove(@PathVariable int taskId) {
		
		taskService.deleteTask(taskId);
		
		return "<h2><font color='green'>Deleted Succesfully</font></h2>";
		

	}
	
	@GetMapping("/search/{keywords}")
	public List<Task> searchTaskByTitle(@PathVariable("keywords")String keywords){
		List<Task> task=taskService.searchTask(keywords);
		return task;
		
	}
}
