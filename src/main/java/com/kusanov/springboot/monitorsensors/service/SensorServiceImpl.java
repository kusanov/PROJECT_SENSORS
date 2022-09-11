package com.kusanov.springboot.monitorsensors.service;

import com.kusanov.springboot.monitorsensors.dao.SensorDAO;
import com.kusanov.springboot.monitorsensors.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorDAO sensorDAO;

    @Override
    @Transactional
    public List<Sensor> getAllSensors() {
        return sensorDAO.getAllSensors();
    }

    @Override
    @Transactional
    public void saveSensor(Sensor sensor) {
        sensorDAO.saveSensor(sensor);
    }

    @Override
    @Transactional
    public Sensor getSensor(int id) {
        return sensorDAO.getSensor(id);
    }

    @Override
    @Transactional
    public void deleteSensor(int id) {
        sensorDAO.deleteSensor(id);
    }

    @Override
    public List<Sensor> searchSensors(String name) {
        return sensorDAO.searchSensors(name);
    }
}