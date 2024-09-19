package com.springmvc.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Demon {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
//    @Column(nullable = false, unique = true, length = 300)
    // Validation Control with 'spring-boot-starter-validation' dependency
    @NotNull(message = "You have to fill out this field")
    @Size(min = 3, max = 75, message = "Name ha to be between 3 to 75 characters long")
    private String name;

    @Min(value = 1, message = "Demon connot be shorter than 1ft")
    @Max(value = 20, message = "Demon cannot be taller than 20 feet")
    private Double height;

    @NotNull(message = "You have to fill out this field")
    @Min(value = 5, message = "No demon should weigh less than 5 pounds")
    @Max(value = 2000, message = "No demon should weigh more than 2 tons, or you should run for than 500")
    private Double weight;
    @NotNull(message = "You have to fill out this field")
    @Size(min = 10, max = 300, message = "You have to describe the demon within 25 to 300 characters")
    private String description;

    //
    public Demon(){}

    public Demon(String name, Double height, Double weight, String description) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
