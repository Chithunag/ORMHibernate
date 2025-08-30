package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Laptop {


    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", ram='" + ram + '\'' +
                ", student=" + student +
                '}';
    }

    @Id
    private int laptopId;

    private String model;

    private String brand;

    private String ram;

    public List<Student> getStudents() {
        return student;
    }

    public void setStudents(List<Student> student) {
        this.student = student;
    }

    @ManyToMany(mappedBy = "laptops")
    private List<Student> student;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
