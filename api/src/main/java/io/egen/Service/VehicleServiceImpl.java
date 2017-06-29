package io.egen.Service;


import io.egen.Exception.BadRequestException;
import io.egen.Repository.VehicleRepository;
import io.egen.entity.Vehicle;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository Vrepository ;


    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {

        return Vrepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {

        Vehicle vehicle = Vrepository.findOne(vin);
        if (vehicle == null) {
            try {
                throw new NotFoundException ("Vehicle with vin=" +  vin + " not found");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return vehicle;
    }

    @Override
    @Transactional
    public Vehicle create(Vehicle[] vehicle) {
        for (int i = 0; i < vehicle.length; i++) {
            Vehicle existing = Vrepository.findByvin(vehicle[i].getVin());
            if (existing != null) {

                Vrepository.create(vehicle[i]);
            }
            Vrepository.update(vehicle[i]);

        }
        return null;
    }

    @Override
    @Transactional
    public void delete(String vin) {
        Vehicle existing = Vrepository.findOne(vin);
        if (existing == null) {
            try {
                throw new NotFoundException("Vehicle with vin=" + vin + " not found");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        Vrepository.delete(existing);
    }
}






