package com.kusanov.springboot.monitorsensors.dao;

import com.kusanov.springboot.monitorsensors.entity.Sensor;
import com.kusanov.springboot.monitorsensors.entity.Type;

import java.util.List;

public interface SensorDAO {
    List<Sensor> getAllSensors();

    void saveSensor(Sensor sensor);

    Sensor getSensor(int id);

    void deleteSensor(int id);

    List<Sensor> searchSensors(String name);

    List<Type> getTypes();
}
