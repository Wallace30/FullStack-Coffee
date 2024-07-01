package com.example.coffee1.coffee;

public record CoffeeResponseDTO(Long id,String name,String description,Double value,String type){

    public CoffeeResponseDTO(Coffee coffee) {
        this(coffee.getId(), coffee.getName(), coffee.getDescription(), coffee.getValue(), coffee.getType());
    }
}
