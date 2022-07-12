package com.example.demo.repository;

import com.example.demo.models.Usuario;
import com.example.demo.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
        INTERFACE DE USUARIO
    */
@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {
}
