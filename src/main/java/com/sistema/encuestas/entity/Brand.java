package com.sistema.encuestas.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand")
    private Long id;

    @Column(name= "brand_name", nullable = false)
    private String brand_name;
}
