package com.client.cyber.success.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.client.cyber.success.model.Task;
import com.client.cyber.success.repository.TaskRepo;
import com.client.cyber.success.service.TaskService;



@WebMvcTest(TaskController.class)
class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private TaskRepo taskRepo;
	
	@MockBean
    private TaskService taskService; 
	
	@InjectMocks
	private TaskController taskController;
	
	Task task1= new Task(1,"Pen Task and play","Task description","31-09-2024","High","zo");
	Task task2= new Task(2,"Pen Task and play2","Task description2","1-10-2024","Low","yo");
	Task task3= new Task(3,"Pen Task and play3","Task description3","2-10-2024","Medium","xo");
	
	
	@BeforeEach
	public void setup() {
		//MockitoAnnotations.initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(taskController).build();
	}
	

	@Test
	void testGetAllTask() throws Exception{
		
		List<Task> tasks= Arrays.asList(task1,task2,task3);
		Mockito.when(taskService.getAllTasks(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString())).thenReturn((Page<Task>) tasks);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/tasks/fetchAllTask")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
			
		
	}

	@Test
	void testSearchTaskByTitle() throws Exception {
List<Task> tasks = Arrays.asList(task1, task2);
        
        // Mock the taskService response
        Mockito.when(taskService.searchTask("Pen")).thenReturn(tasks);

        // Act and Assert: Perform GET request and check response
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/tasks/search/{Pen}")  // Update path if necessary
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
	

}
