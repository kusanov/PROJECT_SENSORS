package com.kusanov.springboot.monitorsensors.service;

import com.kusanov.springboot.monitorsensors.dao.SensorDAO;
import com.kusanov.springboot.monitorsensors.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorDAO sensorDAO;

    @Override
    public List<Sensor> getAllSensors() {
        return sensorDAO.getAllSensors();
    }

    @Override
    public void saveSensor(Sensor sensor) {
        sensorDAO.saveSensor(sensor);
    }

    @Override
    public Sensor getSensor(int id) {
        return sensorDAO.getSensor(id);
    }

    @Override
    public void deleteSensor(int id) {
        sensorDAO.deleteSensor(id);
    }
}
