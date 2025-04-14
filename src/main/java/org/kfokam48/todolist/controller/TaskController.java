package org.kfokam48.todolist.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kfokam48.todolist.dto.TaskDto;
import org.kfokam48.todolist.model.Statut;
import org.kfokam48.todolist.model.Task;
import org.kfokam48.todolist.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")

public class TaskController {

   private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Operation(summary = "Ajouter une tache")
    public Task createTask(
            @Parameter(description = "Les informations pour l'ajout de la tâche a savoir le titre la description et statut")
            @Valid @RequestBody  TaskDto task) {
        return taskService.createTask(task);
    }

    @GetMapping
    @Operation(summary = "Afficher la liste des taches")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Afficher une tache a l'aide de son ID")
    public Task getTask( @PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/statut/{statut}")
    @Operation(summary = "Rechercher une tache par statut")
    public List<Task> getTasksByStatus(
            @Parameter(description = "Le statut de la tâche (A_FAIRE, EN_COUR,TERMINER)")
            @PathVariable Statut statut) {
        return taskService.getTasksByStatus(statut);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Mettre a jour une tâche")
    public Task updateTask(
            @Parameter(description = "L'ID de la tâche a Modifier")
            @PathVariable Long id,
            @Parameter(description = "Les nouvelles information de la tâche a savoir titre , description, Statut")
            @Valid @RequestBody  TaskDto updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer une tache a l'aide de son ID")
    public ResponseEntity<String> deleteTask(
            @Parameter(description = "L'ID de la tâche a Supprimer")
            @PathVariable Long id) {
       return taskService.deleteTaskById(id);
    }




}
