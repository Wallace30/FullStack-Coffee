package com.example.coffee1.controller;

import com.example.coffee1.coffee.Coffee;
import com.example.coffee1.coffee.CoffeeRepository;
import com.example.coffee1.coffee.CoffeeRequestDTO;
import com.example.coffee1.coffee.CoffeeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coffee")
public class CoffeeController {
    @Autowired
    private CoffeeRepository repository;
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    public List<CoffeeResponseDTO> getAll() {
        List<CoffeeResponseDTO> coffeeList = repository.findAll().stream().map(CoffeeResponseDTO::new).toList();
        return coffeeList;
    }
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping()
    public ResponseEntity<String> registerCoffee(@RequestBody Coffee coffee) {
        try {
            Coffee savedCoffee = repository.save(coffee);
            return new ResponseEntity<>("Café registrado com sucesso! ID: " + savedCoffee.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao registrar o café: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
