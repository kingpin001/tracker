package io.egen.Repository;


import io.egen.entity.Alerts;
import io.egen.entity.Readings;
import io.egen.entity.Tires;


import java.util.List;

public interface ReadingRepository {


    List<Readings> findAll();

    Readings findOne(String vin);

    Readings findByvin (String vin);

    Readings create(Tires tires,Readings readings);

    Readings update(Readings readings);

    void delete(Readings readings);

    void CreateAlert( String vin,String priority, String message);

    Readings create(Tires tires,  Readings readings , Alerts obj);


}


