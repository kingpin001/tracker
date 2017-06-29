package io.egen.Repository;


import io.egen.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    List<Vehicle> findAll();

    Vehicle findOne(String vin);

    Vehicle findByvin (String vin);

    void create(Vehicle vehicle);

    Vehicle update( Vehicle vehicle);

    void delete(Vehicle vehicle);
}
