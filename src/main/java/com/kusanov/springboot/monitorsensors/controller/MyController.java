package com.kusanov.springboot.monitorsensors.controller;

import com.kusanov.springboot.monitorsensors.entity.Sensor;
import com.kusanov.springboot.monitorsensors.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
public class MyController{
    @Autowired
    private SensorService sensorService;

    @GetMapping("/")
    public String goToWelcome(Model model) {
        List<Sensor> allSensors = sensorService.getAllSensors();
        model.addAttribute("allSens",allSensors);
        return "welcome";
    }
//
//    @GetMapping("/sensors")
////    public List<Sensor> showAllSensors() {
//    public String showAllSensors() {
//        List<Sensor> allSensors = sensorService.getAllSensors();
////        return allSensors;
//        return "sensor-info";
//    }

    @GetMapping("/sensors/{id}")
    public String getSensor(@PathVariable int id) {
        Sensor sensor = sensorService.getSensor(id);

        return "welcome";
    }

    @GetMapping("/addNewSensor")
    public String addNewSensor(Model model) {
//        Sensor sensor = new Sensor();
        Sensor sensor = sensorService.getSensor(1);
        model.addAttribute("sensor",sensor);
        return "sensor-info";
    }

//    @PostMapping("/saveSensor")
    @GetMapping("/saveSensor")
//    public String saveSensor(Sensor sensor,Model model) {
    public String saveSensor(@ModelAttribute("sensor") Sensor sensor,Model model) {
        System.out.println(sensor.getName());
model.getAttribute("sensor");
        sensorService.saveSensor(sensor);
        return "redirect:/";

    }
//    @PutMapping("/edit/{id}")
    @GetMapping("/edit/{id}")
    public String updateSensor(@PathVariable("id") int id, Model model) {
        Sensor sensor = sensorService.getSensor(id);
        model.addAttribute("sensor",sensor);
//        sensorService.saveSensor(sensor);
        return "sensor-info";

    }

//    @DeleteMapping("/delete/{id}")
    @GetMapping("/delete/{id}")
    public String deleteSensor(@PathVariable int id) {
        sensorService.deleteSensor(id);
//        return "Employee with ID = " + id + " was deleted";
        return "redirect:/";

    }
}