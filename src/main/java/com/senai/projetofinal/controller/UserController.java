package com.senai.projetofinal.controller;

import com.senai.projetofinal.model.User;
import com.senai.projetofinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return  ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> insertUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.cadastrarUser(user));
        }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Object> getUser(@PathVariable(value = "id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listarUser(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object>deleteUser(@PathVariable (value = "id") Integer id){
        userService.removerUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario removido da base de dado!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable (value = "id") Integer id, @RequestBody User user){
        Optional<User> dadosUser = userService.listarUser(id);
        User alterarUser = dadosUser.get();
        alterarUser.setUsuario(user.getUsuario());
        alterarUser.setNivel(user.getNivel());
        alterarUser.setPersonagem(user.getPersonagem());
        alterarUser.setPontos(user.getPontos());

        return ResponseEntity.status(HttpStatus.OK).body(userService.cadastrarUser(alterarUser));
    }

}
