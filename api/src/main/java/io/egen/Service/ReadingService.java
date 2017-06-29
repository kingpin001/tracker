package io.egen.Service;

import io.egen.entity.Readings;
import io.egen.entity.Tires;
import io.egen.entity.Vehicle;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReadingService {


    List<Readings> findAll();

    Readings findOne(String vin);

    Readings create(Readings readings);

    void delete(String vin);



}






