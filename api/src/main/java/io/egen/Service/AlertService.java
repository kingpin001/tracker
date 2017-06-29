package io.egen.Service;


import io.egen.entity.Alerts;


import java.util.List;

public interface AlertService {

    List<Alerts> findAll() ;
    List<Alerts> findByVin(String vin);


}
