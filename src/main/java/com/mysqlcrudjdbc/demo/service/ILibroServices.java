package com.mysqlcrudjdbc.demo.service;

import java.util.List;

import com.mysqlcrudjdbc.demo.model.Libro;

public interface ILibroServices {
    public List<Libro> findAll();
    //... other methods here
    public List<Libro> findActive();
    public int save(Libro libro);
    public int udpate(Libro libro);
    public int deleteById(int id);
}
