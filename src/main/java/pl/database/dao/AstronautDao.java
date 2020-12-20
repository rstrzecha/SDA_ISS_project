package pl.database.dao;

import pl.database.Entity.Astronaut;

import java.util.List;

public interface AstronautDao {

    void save(Astronaut astronaut);         //C U
    Astronaut findById(Long id);      //R
    List<Astronaut> findAll();        //R
    void deleteById(Long id);   //D
}
