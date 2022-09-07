package com.itmo.compstore.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Role name can't be empty")
    @Size(min = 2, max = 100, message = "Role name must be between 2 and 100 symbols")
    @Column(name = "role")
    private String role;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
