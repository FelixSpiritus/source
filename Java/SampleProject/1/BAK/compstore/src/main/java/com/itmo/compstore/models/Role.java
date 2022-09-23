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
@Table(name = "Role")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Role name can't be empty")
    @Size(min = 2, max = 100, message = "Role name must be between 2 and 100 symbols")
    @Column(name = "role")
    private String role;

    public Role(String role) {
        this.role = role;
    }
}
