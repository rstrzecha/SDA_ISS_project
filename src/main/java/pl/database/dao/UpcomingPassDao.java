package pl.database.dao;

import pl.database.Entity.UpcomingPass;

import java.util.List;

public interface UpcomingPassDao {
    void save(UpcomingPass upcomingPass);         //C U
    UpcomingPass findById(Long id);      //R
    List<UpcomingPass> findAll();        //R
    void deleteById(Long id);   //D
}
