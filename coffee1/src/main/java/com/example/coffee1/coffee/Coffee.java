package com.example.coffee1.coffee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "coffees")
@Entity(name = "coffees")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Coffee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String description;
    private Double value;
    private String type;


    public Coffee(CoffeeRequestDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.value = data.value();
        this.type = data.type();
    }

}
