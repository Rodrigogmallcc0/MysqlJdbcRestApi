package com.mysqlcrudjdbc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysqlcrudjdbc.demo.model.Libro;
import com.mysqlcrudjdbc.demo.repository.ILibroRepository;

@Service
public class LibroServicesImpl implements ILibroServices{

    @Autowired
    private ILibroRepository iLibroRepository;
    @Override
    public List<Libro> findAll() {
        List<Libro> list;
        try{
            list=iLibroRepository.findAll();
        }catch(Exception e){
            throw e;
        }
        return list;
    }

    @Override
    public List<Libro> findActive() {

        List<Libro> listActive;
        try {
            listActive = iLibroRepository.findActive();
        } catch (Exception e) {
            throw e;
        }
        return listActive;
    }

    @Override
    public int save(Libro libro) {
        int row;
        try {
            row= iLibroRepository.save(libro);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }

    @Override
    public int udpate(Libro libro) {
        int row;
        try {
            row= iLibroRepository.udpate(libro);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try {
            row=iLibroRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }
    
}
