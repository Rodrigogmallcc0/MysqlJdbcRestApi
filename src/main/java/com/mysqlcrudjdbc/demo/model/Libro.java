package com.mysqlcrudjdbc.demo.model;


import lombok.Data;

@Data
public class Libro {
    int id;
    String nombre;
    String autor;
    String hojas;
    Double precio;
    String fechaRegistro;
    String fechaPublicacion;
    int status;
    String code;
}
