package io.egen.Repository;
import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class VehicleRepositoryImpl implements VehicleRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findAll",Vehicle.class);
        return query.getResultList();
    }

    @Override
    public Vehicle findOne(String vin) {
        return em.find(Vehicle.class,vin);
    }

    @Override
    public Vehicle findByvin (String vin) {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findByVin",Vehicle.class);
        query.setParameter("pVin", vin);
        List<Vehicle> resultList = query.getResultList();

        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        }
        else return null ;
    }

    @Override
    public void create(Vehicle vehicle) {
        em.persist(vehicle);
    }
    @Override
    public Vehicle update(Vehicle vehicle) {
        em.merge(vehicle);
        return null;
    }

    @Override
    public void delete(Vehicle vehicle) {
        em.remove(vehicle);

    }
}
