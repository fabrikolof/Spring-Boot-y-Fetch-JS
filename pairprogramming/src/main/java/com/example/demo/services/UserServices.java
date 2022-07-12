package com.example.demo.services;

import com.example.demo.models.Usuario;
import com.example.demo.repository.UserRepository;
import com.example.demo.models.Usuario;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public Usuario saveUser(Usuario user){
        return userRepository.save(user);
    }

    //Optional<T> findById(ID id);
    public Optional<Usuario> findUserById(Long id){
        return userRepository.findById(id);
    }

    //Iterable<T> findAll();
    // (CASTEO) userRepository.findAll()
    public ArrayList<Usuario> findAllUsers(){
        return (ArrayList<Usuario>) userRepository.findAll();
    }

    //void deleteById(ID id);
    public boolean deleteUserById(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch(Exception err) {
            return false;
        }
    }

}
