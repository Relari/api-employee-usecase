package com.example.demoapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class: DemoEntity.
 * @version 1.0.0
 * @author Relari
 */

@Entity
@Table(name = "Demo")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", length = 50, nullable = false)
    private String description;

}
