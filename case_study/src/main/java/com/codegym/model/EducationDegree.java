package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEducationDegree;
    private String nameEducationDegree;

    @OneToMany(mappedBy = "educationDegrees", cascade = CascadeType.ALL)
    private Set<Employee> employee;

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public EducationDegree() {
    }

    public EducationDegree(Integer idEducationDegree, String nameEducationDegree) {
        this.idEducationDegree = idEducationDegree;
        this.nameEducationDegree = nameEducationDegree;
    }

    public Integer getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(Integer idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public String getNameEducationDegree() {
        return nameEducationDegree;
    }

    public void setNameEducationDegree(String nameEducationDegree) {
        this.nameEducationDegree = nameEducationDegree;
    }
}
