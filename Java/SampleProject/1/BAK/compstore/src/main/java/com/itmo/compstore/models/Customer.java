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
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Customer name can't be empty")
    @Size(min = 2, max = 150, message = "Title must be between 2 and 150 symbols")
    @Column(name = "name")
    private  String name;

    @NotEmpty(message = "Customer surname can't be empty")
    @Size(min = 2, max = 150, message = "Title must be between 2 and 150 symbols")
    @Column(name = "surname")
    private  String surname;

    @Size(max = 150, message = "Company name must be maximum 150 symbols")
    @Column(name = "companyname")
    private  String companyname;


    @Size(max = 100, message = "Country must be maximum 100 symbols")
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

    @Column(name = "zipcode")
    private String zipcode;

    @Size(max = 20, message = "Phone number must be maximum 20 symbols")
    @Column(name = "tel")
    private  String tel;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    public Customer(String name, String surname, String companyname, String country, String city, String region, String address, String zipcode, String tel) {
        this.name = name;
        this.surname = surname;
        this.companyname = companyname;
        this.country = country;
        this.city = city;
        this.region = region;
        this.address = address;
        this.zipcode = zipcode;
        this.tel = tel;
    }
}
