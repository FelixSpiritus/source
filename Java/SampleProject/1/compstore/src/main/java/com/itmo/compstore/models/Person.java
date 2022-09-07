package com.itmo.compstore.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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


    public Person() {
    }

    public Person(String username, String name, String surname, String password, Role role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}