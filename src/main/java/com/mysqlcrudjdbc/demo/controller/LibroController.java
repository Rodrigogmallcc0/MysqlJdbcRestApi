package com.mysqlcrudjdbc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysqlcrudjdbc.demo.model.Libro;
import com.mysqlcrudjdbc.demo.model.ServicesResponse;
import com.mysqlcrudjdbc.demo.service.ILibroServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class LibroController {
    
    @Autowired
    private ILibroServices iLibroServices;
    @GetMapping("")
    public ResponseEntity<List<Libro>> listBook() {
        var result= iLibroServices.findAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Libro>> listBookActive(){
        List <Libro> libros =  this.iLibroServices.findActive();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    //public SomeData getMethodName(@RequestParam String param) {
    //    return new SomeData();
    //}
    @GetMapping("/fizzbuzz")
    public String fizzbuzz(){
        StringBuilder builder= new StringBuilder();
        for(int number=1;number<=100;number++){
        if (number%3==0 & number%5==0) {
            builder.append( "fizzbuzz");            
        }if (number%3==0) {
            builder.append("fizz");
            
        } if (number%5==0) {
            builder.append("buzz");
        }
         else{
            builder.append(number).append(" ");
        }
    }   return builder.toString();
    } 
    @PostMapping("/save")
    public ResponseEntity<ServicesResponse> save(@RequestBody Libro libro){
        ServicesResponse servicesResponse = new ServicesResponse();
        int result = iLibroServices.save(libro);
        if(result==1){
            servicesResponse.setMessage("Libro registrado correctamente");
        }return new ResponseEntity<>(servicesResponse, HttpStatus.OK);        
    }
    @PutMapping("/update")
    public ResponseEntity<ServicesResponse> update(@RequestBody Libro libro){
        ServicesResponse servicesResponse = new ServicesResponse();
        int result = iLibroServices.udpate(libro);
        if (result==1){
            servicesResponse.setMessage("Actualizado correctamente");
        }return new ResponseEntity<>(servicesResponse, HttpStatus.OK);
    }
    @PatchMapping("/delete/{id}")
    public ResponseEntity<ServicesResponse> delete(@PathVariable int id){
        ServicesResponse servicesResponse = new ServicesResponse();
        int result = iLibroServices.deleteById(id);
        if (result==1){
            servicesResponse.setMessage("Libro eliminado");
        }
        return new ResponseEntity<>(servicesResponse, HttpStatus.OK);
    }

    

    
}
