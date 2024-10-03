package com.taxi.uber.entities;

import com.taxi.uber.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "app_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    //this is to create separate table for roles
    @ElementCollection(fetch = FetchType.LAZY)

    //this is to store roles as string, ORDINAL is to store in the form of 0,1
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
