package com.client.cyber.success.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.client.cyber.success.model.Task;

public interface TaskService {
	
	Task createTask(Task task);
	int updateTask(Task task,Integer taskId);
	Page<Task> getAllTasks(Integer pageNumber,Integer pageSize,String sortBy);
	void deleteTask(Integer taskId);
	List<Task> searchTask(String keyword);
	

}
