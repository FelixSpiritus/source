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
@Table(name = "Supplier")
public class Supplier {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Supplier name can't be empty")
    @Size(min = 2, max = 150, message = "Title must be between 2 and 150 symbols")
    @Column(name = "name")
    private  String name;

    @NotEmpty(message = "Country name can't be empty")
    @Size(min = 2, max = 100, message = "Country must be between 2 and 100 symbols")
    @Column(name = "country")
    private  String country;

    @Size(max = 50, message = "City must be maximum 50 symbols")
    @Column(name = "city")
    private  String city;

    @Size(max = 100, message = "Region must be maximum 100 symbols")
    @Column(name = "region")
    private  String region;

    @Column(name = "address")
    private  String address;

    @Size(max = 20, message = "Phone number must be between 2 and 20 symbols")
    @Column(name = "tel")
    private  String tel;

    @Size(max = 50, message = "Phone number must be between 2 and 50 symbols")
    @Column(name = "contactname")
    private  String contactname;

    public Supplier(String name, String country, String city, String region, String address, String tel, String contactname) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.region = region;
        this.address = address;
        this.tel = tel;
        this.contactname = contactname;
    }
}
