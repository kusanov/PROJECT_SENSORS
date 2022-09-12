package com.kusanov.springboot.monitorsensors.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "monitorsensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @NotBlank(message = "Name not blank!")
    @Size(min = 2,max = 30,message = "Wrong name length!")
    private String name;
    @Column(name = "model")
    @NotBlank(message = "Model not blank!")
    @Size(min = 2,max = 15,message = "Wrong model length!")
    private String model;
    @Column(name = "range_from")
    @Min(value = 1,message = "Range from min=1")
    private int rangeFrom;
    @Column(name = "range_to")
    @Min(value = 2,message = "Range to min=2")
    private int rangeTo;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    @Column(name = "description")
    @Size(min = 2,max = 200,message = "Wrong description length!")
    private String description;


    public Sensor() {
    }

    public Sensor(int id, String name, String model, int rangeFrom, int rangeTo, Type type, String description) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.type = type;
        this.description = description;
    }

    public Sensor(String name, String model, int rangeFrom, int rangeTo, Type type, String description) {
        this.name = name;
        this.model = model;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.type = type;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(int rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public int getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(int rangeTo) {
        this.rangeTo = rangeTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Model='" + model + '\'' +
                ", rangeFrom=" + rangeFrom +
                ", rangeTo=" + rangeTo +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
