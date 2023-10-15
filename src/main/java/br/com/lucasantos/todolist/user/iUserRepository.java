package br.com.lucasantos.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;



public interface iUserRepository  extends JpaRepository<userModel,UUID>{
    userModel findByUsername(String username);
    
}
