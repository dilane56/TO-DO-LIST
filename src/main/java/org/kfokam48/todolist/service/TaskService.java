package org.kfokam48.todolist.service;

import org.kfokam48.todolist.dto.TaskDto;
import org.kfokam48.todolist.model.Statut;
import org.kfokam48.todolist.model.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface TaskService {
    Task createTask(TaskDto task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    ResponseEntity<String> deleteTaskById(Long id);
    Task updateTask(Long id, TaskDto updateTask);
    List<Task> getTasksByStatus(Statut status);
}
