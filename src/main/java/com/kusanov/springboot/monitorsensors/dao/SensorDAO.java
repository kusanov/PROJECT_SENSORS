package com.kusanov.springboot.monitorsensors.dao;

import com.kusanov.springboot.monitorsensors.entity.Sensor;

import java.util.List;

public interface SensorDAO {
    public List<Sensor> getAllSensors();

    public void saveSensor(Sensor sensor);

    public Sensor getSensor(int id);

    public void deleteSensor(int id);
}
