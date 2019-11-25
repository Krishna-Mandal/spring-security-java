package com.krishna.springsecurityjava.models;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
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
