package com.codegym.model;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameEmployee;
    private String dayOBEmployee;
    private String idCardEmployee;
    private double salaryEmployee;
    private String phoneEmployee;
    private String emailEmployee;
    private String addressEmployee;

    @ManyToOne
    @JoinColumn(name = "id_position", referencedColumnName = "idPosition")
    private Position positions;

    @ManyToOne
    @JoinColumn(name = "id_division", referencedColumnName = "idDivision")
    private Division divisions;

    @ManyToOne
    @JoinColumn(name = "id_education_degree", referencedColumnName = "idEducationDegree")
    private EducationDegree educationDegrees;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDayOBEmployee() {
        return dayOBEmployee;
    }

    public void setDayOBEmployee(String dayOBEmployee) {
        this.dayOBEmployee = dayOBEmployee;
    }

    public String getIdCardEmployee() {
        return idCardEmployee;
    }

    public void setIdCardEmployee(String idCardEmployee) {
        this.idCardEmployee = idCardEmployee;
    }

    public double getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(double salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public Position getPositions() {
        return positions;
    }

    public void setPositions(Position positions) {
        this.positions = positions;
    }

    public Division getDivisions() {
        return divisions;
    }

    public void setDivisions(Division divisions) {
        this.divisions = divisions;
    }

    public EducationDegree getEducationDegrees() {
        return educationDegrees;
    }

    public void setEducationDegrees(EducationDegree educationDegrees) {
        this.educationDegrees = educationDegrees;
    }
}
