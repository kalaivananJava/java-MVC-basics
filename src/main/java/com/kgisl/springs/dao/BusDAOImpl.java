package com.kgisl.springs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgisl.springs.entity.Bus;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class BusDAOImpl implements BusDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Bus> getBus() {
           Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Bus> cq = cb.createQuery(Bus.class);
        Root<Bus> root = cq.from(Bus.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveBus(Bus theBus) {
       Session currentSession = sessionFactory.getCurrentSession();
       currentSession.persist(theBus);
    }

    @Override
    public void updateBus(Bus theBus) {
        Session currentSession = sessionFactory.getCurrentSession();
        int id=theBus.getId();
        Bus detachedCustomer = currentSession.get(Bus.class, id);
        detachedCustomer.setFirstName(theBus.getFirstName());
        detachedCustomer.setLastName(theBus.getLastName());
        detachedCustomer.setEmail(theBus.getEmail());
        // Get the detached customer
        System.out.println(detachedCustomer);
        currentSession.merge(detachedCustomer);     
    }

    @Override
    public void getBusById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBusById'");
    }

    @Override
    public void deleteBus(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBus'");
    }
    

}
