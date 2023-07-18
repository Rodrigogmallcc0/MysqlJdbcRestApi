package com.mysqlcrudjdbc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysqlcrudjdbc.demo.model.Libro;
import com.mysqlcrudjdbc.demo.service.ILibroServices;

import org.springframework.web.bind.annotation.GetMapping;


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
    
}
