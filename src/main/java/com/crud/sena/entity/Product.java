package com.crud.sena.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product", unique = true, nullable = false)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 100)
    private String description;

    private double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}
