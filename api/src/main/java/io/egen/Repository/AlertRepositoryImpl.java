package io.egen.Repository;


import io.egen.entity.Alerts;
import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Alerts> findAll() {
        TypedQuery<Alerts> query = em.createNamedQuery("Alerts.findAll",Alerts.class);
        return query.getResultList();
    }



    @Override
    public List<Alerts> findByVin (String vin) {
        TypedQuery<Alerts> query = em.createNamedQuery("Alerts.findByVin",Alerts.class);
        query.setParameter("pVin", vin);
        return query.getResultList();
    }




}



