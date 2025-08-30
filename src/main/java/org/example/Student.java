package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    private int rollNo;
    private String sName;
    private int sAge;

    public List<Laptop> getLaptop() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @ManyToMany
    private List<Laptop> laptops;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                ", laptops" + laptops +
                '}';
    }
}
