package io.egen.Repository;

import io.egen.entity.Alerts;
import io.egen.entity.Readings;
import io.egen.entity.Tires;
import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Readings> findAll() {
        TypedQuery<Readings> query = em.createNamedQuery("Readings.findAll",Readings.class);
        return query.getResultList();
    }

    @Override
    public Readings findOne(String vin) {
        return em.find(Readings.class, vin);
    }

    @Override
    public Readings findByvin(String vin) {
        TypedQuery<Readings> query = em.createNamedQuery("Readings.findByVin", Readings.class);
        query.setParameter("pVin", vin);
        List<Readings> resultList = query.getResultList();

        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else return null;
    }

    @Override
    public void CreateAlert(String vin, String Message, String priority) {
        Alerts object = new Alerts();
        object.setMessage(Message);
        object.setPriority(priority);
        object.setVin(vin);
        object.setTimeStamp(new Date());
        em.persist(object);
    }

    @Override
    public Readings create(Tires tires, Readings readings,Alerts obj) {

        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findByVin",Vehicle.class);
        query.setParameter("pVin",readings.getVin());

        if(readings.getEngineRpm() > query.getResultList().get(0).getRedlineRpm()){
            CreateAlert(readings.getVin(),"vehicle Rpm is very high  attention is necessary","High");
        }

        if(readings.getFuelVolume() < ((query.getResultList().get(0).getMaxFuelVolume())/10)){

            CreateAlert(readings.getVin(),"Fuel volume is Low attention is needed","Medium");
        }

        em.persist(tires);
        em.persist(readings);
        em.persist(obj);

        return readings;
    }

    @Override
    public Readings create( Tires tires,Readings readings) {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findByVin",Vehicle.class);

        query.setParameter("pVin",readings.getVin());

        if(query.getResultList().get(0).getRedlineRpm() < readings.getEngineRpm()){
            CreateAlert(readings.getVin()," RPM is very High","High");
        }

        if(readings.getFuelVolume() < ((query.getResultList().get(0).getMaxFuelVolume())/10)){

            CreateAlert(readings.getVin(),"Fuel is Low","Medium");
        }

        em.persist(tires);
        em.persist(readings);

        return readings;

    }

    @Override
    public Readings update(Readings readings) {
        return em.merge(readings);
    }

    @Override
    public void delete(Readings readings) {
        em.remove(readings);
    }
}
