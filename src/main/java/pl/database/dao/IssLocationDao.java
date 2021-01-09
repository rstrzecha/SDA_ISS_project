package pl.database.dao;

import pl.database.Entity.IssLocation;

import java.util.List;

public interface IssLocationDao {

    void save(IssLocation issLocation);         //C U
    IssLocation findById(Long id);      //R
    List<IssLocation> findAll();        //R
    void deleteById(Long id);   //D
}
