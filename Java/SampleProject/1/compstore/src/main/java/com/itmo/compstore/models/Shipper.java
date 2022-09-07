package com.itmo.compstore.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Shipper")
public class Shipper {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Shipper name can't be empty")
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

    @Size(max = 20, message = "Phone number must be between 2 and 50 symbols")
    @Column(name = "tel")
    private  String tel;
}
