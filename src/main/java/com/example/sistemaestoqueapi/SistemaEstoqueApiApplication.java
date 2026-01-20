package com.example.sistemaestoqueapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.sistemaestoqueapi")
public class SistemaEstoqueApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemaEstoqueApiApplication.class, args);
    }
}
