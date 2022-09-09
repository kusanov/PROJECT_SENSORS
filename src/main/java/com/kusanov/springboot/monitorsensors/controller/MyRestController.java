package com.kusanov.springboot.monitorsensors.controller;

import com.kusanov.springboot.monitorsensors.entity.Sensor;
import com.kusanov.springboot.monitorsensors.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
public class MyRestController extends HttpServlet{
    @Autowired
    SensorService sensorService;


    @GetMapping("/sensors")
    public List<Sensor> showAllSensors() {
        List<Sensor> allSensors = sensorService.getAllSensors();
        return allSensors;
    }

    @GetMapping("/sensors/{id}")
    public Sensor getSensor(@PathVariable int id) {
        Sensor sensor = sensorService.getSensor(id);

        return sensor;
    }

    @PostMapping("/sensors")
    public Sensor addNewSensor(@RequestBody Sensor sensor) {
        sensorService.saveSensor(sensor);
        return sensor;
    }

    @PutMapping("/sensors")
    public Sensor updateSensor(@RequestBody Sensor sensor) {
        sensorService.saveSensor(sensor);
        return sensor;
    }

    @DeleteMapping("/sensors/{id}")
    public String deleteSensor(@PathVariable int id) {
        sensorService.deleteSensor(id);
        return "Employee with ID = " + id + " was deleted";
    }
}