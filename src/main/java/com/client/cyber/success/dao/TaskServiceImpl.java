package com.client.cyber.success.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.client.cyber.success.model.Task;
import com.client.cyber.success.repository.TaskRepo;
import com.client.cyber.success.service.TaskService;
import org .springframework.data.domain.Pageable;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskRepo taskRepo;

	@Override
	public Task createTask(Task task) {
		return taskRepo.save(task);
	}

	@Override
	public int updateTask(Task task, Integer taskId) {
		int updateStatus=taskRepo.updateTask(task.getTitle(),task.getDescription(), task.getStatus(), task.getPriority(), taskId);
		if(updateStatus!=0) {
			return updateStatus;
		}
		else {
			return 0;
		}
	}

	@Override
	public Page<Task> getAllTasks(Integer pageNumber,Integer pageSize,String sortBy) {
		Pageable p=PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		
		return taskRepo.findAll(p);
	}

	@Override
	public void deleteTask(Integer taskId) {
		taskRepo.deleteById(taskId);
		
		
	}

	@Override
	public List<Task> searchTask(String keyword) {
		List<Task> tasks=taskRepo.searchByTitle("%"+keyword+"%");
		return tasks;
	}

}
