package br.com.lucasantos.todolist.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;


@RestController
@RequestMapping("/users")
public class userController {

            @Autowired
            private iUserRepository  userRepository;



    @PostMapping("/")
    public ResponseEntity create(@RequestBody userModel userModel){
      var user =  this.userRepository.findByUsername(userModel.getUsername());


      if(user != null){
        System.out.println("usuario ja existe");
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("usuario ja exste");
      }
       
        var passwordHashred = BCrypt.withDefaults()
        .hashToString(12,userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

      var userCreated = this.userRepository.save(userModel);
      return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }
   
}
