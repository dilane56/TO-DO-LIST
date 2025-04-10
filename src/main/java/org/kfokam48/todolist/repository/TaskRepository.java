package org.kfokam48.todolist.repository;

import org.kfokam48.todolist.model.Statut;
import org.kfokam48.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatut(Statut statut);
    int countAllByTitle(String title);

}
