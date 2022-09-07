package com.itmo.compstore.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Storage")
public class Storage {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "Title can't be empty")
    @Size(min = 2, max = 50, message = "Title must be between 2 and 50 symbols")
    @Column(name = "title")
    private String title;

    @Column(name = "descr")
    private String descr;

    @OneToMany(mappedBy = "storage")
    private List<StorageItems> storageItems;

    public Storage(String title, String descr) {
        this.title = title;
        this.descr = descr;
    }
}

