package com.codegym.dto;

import com.codegym.model.Division;
import com.codegym.model.EducationDegree;
import com.codegym.model.Position;

import javax.validation.constraints.*;

public class EmployeeDto {

    private Integer id;

    @NotNull(message = "Bắt buộc phải nhập nha!")
    @NotBlank(message = "Tên không được để trống nha!")
    @Size(min = 5, max = 45, message = "Tên thì phải nhiều hơn 5 ký tự và ít gơn 45 ký tự nha!")
    private String nameEmployee;

    @NotNull(message = "Bắt buộc phải nhập nha!")
    @NotBlank(message = "Tên không được để trống nha!")
    private String dayOBEmployee;

    @NotNull(message = "Bắt buộc phải nhập nha!")
    @NotBlank(message = "Tên không được để trống nha!")
    @Pattern(regexp = "[0-9]{9,12}")
    private String idCardEmployee;

    @NotNull(message = "Bắt buộc phải nhập nha!")
    @Min(value = 0, message = "Lương phải lớn hơn bằng 0 nha!")
    private double salaryEmployee;

    @NotNull(message = "Bắt buộc phỉa nhập nha! ")
    @NotBlank(message = "Tên không được để trống nha!")
    @Pattern(regexp = "(0[3|7|8|5|9])+([0-9]{8,9})$", message = "số bắt đầu bằng 0, và phải 10 hoặc 11 số")
    private String phoneEmployee;

    @NotNull(message = "Bắt buộc phải nhập nha! ")
    @NotBlank(message = "Không được để rỗng nha!")
    @Email(message = "mail phỉa đúng chuẩn mới đươc")
    private String emailEmployee;

    @NotNull(message = "Bắt buộc phải nhập nha!")
    @NotBlank(message = "Tên không được để trống nha!")
    private String addressEmployee;

    private Position positions;

    private Division divisions;

    private EducationDegree educationDegrees;

    public EmployeeDto() {
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
