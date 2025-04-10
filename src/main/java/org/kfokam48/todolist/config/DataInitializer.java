package org.kfokam48.todolist.config;

import org.kfokam48.todolist.model.Statut;
import org.kfokam48.todolist.model.Task;
import org.kfokam48.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        Task task = new Task();
        task.setTitle("Task 1");
        task.setDescription("Description de tâche 1");
        task.setStatut(Statut.TERMINE);
        taskRepository.save(task);

        Task task2 = new Task();
        task2.setTitle("Task 2");
        task2.setDescription("Description de tâche 2");
        task2.setStatut(Statut.EN_COURS);
        taskRepository.save(task2);

        Task task3 = new Task();
        task3.setTitle("Task 3");
        task3.setDescription("Description de tâche 3");
        task3.setStatut(Statut.A_FAIRE);
        taskRepository.save(task3);

        Task task4 = new Task();
        task4.setTitle("Task 4");
        task4.setDescription("Description de tâche 4");
        task4.setStatut(Statut.A_FAIRE);
        taskRepository.save(task4);

        Task task5 = new Task();
        task5.setTitle("Task 5");
        task5.setDescription("Description de tâche 5");
        task5.setStatut(Statut.A_FAIRE);
        taskRepository.save(task5);



    }



}
