package com.vnpt.store_it.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table(name = "user")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "created_at", updatable = false , insertable = false)
    private Date created;
}
