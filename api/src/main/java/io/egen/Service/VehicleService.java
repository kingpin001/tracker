package io.egen.Service;
import io.egen.entity.Vehicle;

import java.util.List;
public interface VehicleService {

    List<Vehicle> findAll();

    Vehicle findOne(String vin);

    Vehicle  create(Vehicle[] vehicle);


    void delete(String vin);



}

