package com.kusanov.springboot.monitorsensors.service;

import com.kusanov.springboot.monitorsensors.entity.Sensor;

import java.util.List;

public interface SensorService {
    List<Sensor> getAllSensors();

    void saveSensor(Sensor sensor);

    Sensor getSensor(int id);

    void deleteSensor(int id);
    List<Sensor> searchSensors(String name);}
