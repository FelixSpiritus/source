package com.itmo.compstore.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username can't be empty")
    @Size(min = 2, max = 100, message = "Username must be between 2 and 100 symbols")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 symbols")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Surname can't be empty")
    @Size(min = 2, max = 100, message = "Surname must be between 2 and 100 symbols")
    @Column(name = "surname")
    private String surname;

   @Column(name = "password")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    public Person(String username, String name, String surname, String password, Role role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }
}