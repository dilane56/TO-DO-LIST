package org.kfokam48.todolist.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.kfokam48.todolist.dto.TaskDto;
import org.kfokam48.todolist.exceptions.TaskNotFoundException;
import org.kfokam48.todolist.exceptions.UniqueConstraintViolationException;
import org.kfokam48.todolist.mapper.TaskMapper;
import org.kfokam48.todolist.model.Statut;
import org.kfokam48.todolist.model.Task;
import org.kfokam48.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task createTask(@Valid TaskDto task) {
        checkUniqueTitle(task);

        return taskRepository.save(taskMapper.convertTaskDtoToTask(task));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("La tache avec ID : " + id + " n'existe pas"));
    }

    @Override
    public ResponseEntity<String> deleteTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("La tache avec ID : " + id + " n'existe pas"));
        taskRepository.deleteById(id);
        return ResponseEntity.ok("la tache avec l'ID: " + id + "  a été supprimer avec succès");
    }

    @Override
    public Task updateTask(Long id, @Valid TaskDto updateTask) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("La tache avec ID : " + id + " n'existe pas"));
        List<Task> tasks = taskRepository.findAll();
        for (Task t : tasks) {
            if (t.getTitle().equals(updateTask.getTitle()) && !Objects.equals(t.getId(), id)) {
                throw new UniqueConstraintViolationException("Une Tache existe deja avec ce titre :" + updateTask.getTitle());
            }
        }

        task.setTitle(updateTask.getTitle());
        task.setDescription(updateTask.getDescription());
        task.setStatut(updateTask.getStatut());

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByStatus(Statut status) {
        return taskRepository.findByStatut(status);
    }

    private void checkUniqueTitle(TaskDto dto) {
        if (taskRepository.countAllByTitle(dto.getTitle()) > 0)
            throw new UniqueConstraintViolationException("Field Title must be UNIQUE");
    }
}
