package br.com.lucasantos.todolist.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface itaskRepository extends JpaRepository<TaskModel,UUID> {
    List<TaskModel> findByIdUser(UUID idUser);
}
