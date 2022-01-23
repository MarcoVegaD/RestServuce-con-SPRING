package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//RestController marca primero la clase como un controlador donde cada metodo regresara un objeto en lugar de una vista
@RestController
public class GreetingController{

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    //GetMapping para asegurar un metodo get en la direccion URL dada
    @GetMapping("/greeting")
    //En RequestParam value hace referencia al valor en la URL, y el String name es para usar en el metodo
    public Greeting greeting(@RequestParam(value = "nombre", defaultValue = "World")String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}