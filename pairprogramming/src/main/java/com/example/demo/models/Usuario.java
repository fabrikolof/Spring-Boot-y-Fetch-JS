package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="user")
public class Usuario {

    @Id//indica que es una llave primaria --> PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Genera valores dependiendo de la estrategia implementada
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 3)
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
