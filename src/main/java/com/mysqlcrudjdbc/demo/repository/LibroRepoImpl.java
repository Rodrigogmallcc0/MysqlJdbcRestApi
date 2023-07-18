package com.mysqlcrudjdbc.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysqlcrudjdbc.demo.model.Libro;

@Repository
public class LibroRepoImpl implements ILibroRepository{

    @Autowired
    private JdbcTemplate jdbcTempalte;

    @Override
    public List<Libro> findAll() {
        String query= "Select * from book";
        return jdbcTempalte.query(query, BeanPropertyRowMapper.newInstance(Libro.class));

    }

    @Override
    public List<Libro> findActive() {
        String query = "Select * from book where status ='1'";
        return jdbcTempalte.query(query, BeanPropertyRowMapper.newInstance(Libro.class ));
    }

    @Override
    public int save(Libro libro) {
        String save = "insert into book(nombre, autor, hojas, precio, fechaRegistro, fechaPublicacion, status,code) values (?,?,?,?,?,?,?,?)";
        return jdbcTempalte.update(save, new Object[]{libro.getNombre(), libro.getAutor(), libro.getHojas(), libro.getPrecio(),libro.getFechaRegistro(),libro.getFechaPublicacion(),libro.getStatus(),libro.getCode()}); 

    }

    @Override
    public int udpate(Libro libro) {
        String update = "update book set nombre=?, autor=?, hojas=?, precio=?, fechaRegistro=?, fechaPublicacion=?, status=?, code=? where id=?";
        return jdbcTempalte.update(update, new Object[]{libro.getNombre(), libro.getAutor(), libro.getHojas(), libro.getPrecio(),libro.getFechaRegistro(),libro.getFechaPublicacion(),libro.getStatus(),libro.getCode(),libro.getId()}); 

    }

    @Override
    public int deleteById(int id) {
        String delete = "update book set status='0' where id=?";
        return jdbcTempalte.update(delete, new Object[]{id});
    }
    
}
