package com.svhellen.todosimple.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svhellen.todosimple.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByUser_id(Long id);
}
