package io.egen.Repository;

import io.egen.entity.Alerts;
import io.egen.entity.Vehicle;

import java.util.List;


public interface AlertRepository {


    List<Alerts> findAll();

    List<Alerts> findByVin(String vin);


}


