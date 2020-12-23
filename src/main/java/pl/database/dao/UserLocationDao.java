package pl.database.dao;

import pl.database.Entity.UserLocation;

import java.util.List;

public interface UserLocationDao {
    void save(UserLocation userLocation);         //C U
    UserLocation findById(Long id);      //R
    List<UserLocation> findAll();        //R
    void deleteById(Long id);   //D
}
