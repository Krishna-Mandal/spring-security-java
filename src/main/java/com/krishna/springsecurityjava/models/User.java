package com.krishna.springsecurityjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    @Id
    private @Column(name = "id") Integer id;

    @Getter @Setter
    private @Column(name = "user") String userName;

    @Getter @Setter
    private @Column(name = "password") String password;

    @Getter @Setter
    private @Column(name = "active") boolean active;

    @Getter @Setter
    private @Column(name = "roles") String roles;

}
