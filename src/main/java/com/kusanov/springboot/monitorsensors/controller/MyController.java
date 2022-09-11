package com.kusanov.springboot.monitorsensors.controller;

import com.kusanov.springboot.monitorsensors.entity.Sensor;
import com.kusanov.springboot.monitorsensors.service.SensorService;
import org.hibernate.boot.jaxb.spi.Binding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController{
    @Autowired
    private SensorService sensorService;

    @GetMapping("/")
    public String goToWelcome(Model model) {
        List<Sensor> allSensors = sensorService.getAllSensors();
        model.addAttribute("allSens",allSensors);
        Sensor sensor = new Sensor();
        model.addAttribute("sensor",sensor);
        return "welcome";
    }
    @GetMapping("/error")
    public String getError() {
        return "error";
    }


    @GetMapping("/addNewSensor")
    public String addNewSensor(Model model) {
        Sensor sensor = new Sensor();
        model.addAttribute("sensor",sensor);
        System.out.println(sensor);
        return "sensor-info";
    }

@GetMapping("/saveSensor")
public String saveSensor(@Valid @ModelAttribute("sensor") Sensor sensor, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
        {return "sensor-info";}
        else {
            sensorService.saveSensor(sensor);
            return "redirect:/";
        }
    }
    @GetMapping("/edit/{id}")
    public String updateSensor(@PathVariable("id") int id, Model model) {
        Sensor sensor = sensorService.getSensor(id);
        model.addAttribute("sensor",sensor);
        return "sensor-info";
    }

    @GetMapping("/delete/{id}")
    public String deleteSensor(@PathVariable int id) {
        sensorService.deleteSensor(id);
        return "redirect:/";
    }
    @GetMapping("/search")
    public String searchSensor(@Param("name") String name, Model model) {
        List<Sensor> searchSens = sensorService.searchSensors(name);
        model.addAttribute("searchSens",searchSens);
        return "search";
    }
}