package com.kusanov.springboot.monitorsensors.dao;

import com.kusanov.springboot.monitorsensors.entity.Sensor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SensorDAOImpl implements SensorDAO{
    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Sensor> getAllSensors() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Sensor",Sensor.class);
        List<Sensor> allSensors = query.getResultList();
        return allSensors;
    }

    @Override
    public void saveSensor(Sensor sensor) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(sensor);
    }

    @Override
    public Sensor getSensor(int id) {
        Session session = entityManager.unwrap(Session.class);
Sensor sensor = session.get(Sensor.class,id);
        return sensor;
    }

    @Override
    public void deleteSensor(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Sensor " + " where id =:sensorId");
        query.setParameter("sensorId",id);
        query.executeUpdate();
    }

    @Override
    public List<Sensor> searchSensors(String name) {
        Session session= entityManager.unwrap(Session.class);
        System.out.println(name);
        System.out.println(name);
        Query query = session.createQuery("SELECT sensor from Sensor sensor where name like :name");
        query.setParameter("name",name);
        List<Sensor> searchSensors = query.getResultList();
        return searchSensors;
    }
}
