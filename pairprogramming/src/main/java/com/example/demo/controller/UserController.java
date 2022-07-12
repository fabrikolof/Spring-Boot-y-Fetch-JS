package com.example.demo.controller;

import com.example.demo.models.Usuario;
import com.example.demo.services.UserServices;
import com.example.demo.models.Usuario;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

//@RequestBody - Permite generar un objeto a partir de los datos que llegan vía Maikel JSON


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    //POST
    @PostMapping
    public Usuario saveUser(@RequestBody Usuario user){
        return userServices.saveUser(user);
    }

    //GET
    @GetMapping
    public ArrayList<Usuario> findAllUsers(){
        return userServices.findAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> findUserById(@PathVariable(value = "id") Long id){
        return userServices.findUserById(id);
    }


    //PUT
    //@RequestBody Usuario userDetail, @PathVariable(value = "id")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody Usuario userDetail,@PathVariable(value = "id") Long id){
        Optional<Usuario> user = userServices.findUserById(id);
        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }
        user.get().setId(userDetail.getId());
        user.get().setName(userDetail.getName());
        user.get().setAge(userDetail.getAge());
        return ResponseEntity.status(HttpStatus.CREATED).body(userServices.saveUser(user.get()));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id){
        if(!userServices.findUserById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(userServices.deleteUserById(id));
    }
}
