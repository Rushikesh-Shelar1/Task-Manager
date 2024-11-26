package com.client.cyber.success.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.client.cyber.success.model.Task;

import jakarta.transaction.Transactional;
@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
	@Transactional
	@Modifying
	@Query("update Task t set t.title=?1,t.description=?2,t.status=?3,t.priority=?4 where t.taskId=?5 ")
	public int updateTask(String title,String description,String status,String priority,int taskId);
	
	@Query("select t from Task t where t.title like :key")
	List<Task> searchByTitle(@Param("key")String title);

}
