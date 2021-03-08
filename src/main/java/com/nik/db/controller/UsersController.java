package com.nik.db.controller;

import com.nik.db.dto.UsersDTO;
import com.nik.db.exception.ValidationException;
import com.nik.db.serviсe.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/save")
    public UsersDTO saveUsers(@RequestBody UsersDTO usersDTO) throws ValidationException{
        log.info("Handling save users: " + usersDTO);
        return usersService.saveUser(usersDTO);
    }

    @GetMapping("/findAll")
    public List<UsersDTO> findAllUsers(){
        log.info("Handling find all users request");
        return usersService.findAll();
    }

    @GetMapping("/findByLogin")
    public UsersDTO findByLogin(@RequestParam String login){
        log.info("Handling find by login request: " + login);
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id){
        log.info("Handling delete user request: " + id);
        return ResponseEntity.ok().build();
    }
}
