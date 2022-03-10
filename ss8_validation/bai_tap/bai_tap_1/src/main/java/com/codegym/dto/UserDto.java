package com.codegym.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator{
    private int id;
    @NotNull(message = "Bắt buộc phỉa nhập nha! ")
    @NotBlank(message = "Không được để rỗng nha!")
    @Size(min = 5, max = 45, message = "số ký tự phải nhiều hơn 5 và nhỏ hơn 45!")
    private String firstname;

    @NotNull(message = "Bắt buộc phỉa nhập nha! ")
    @NotBlank(message = "Không được để rỗng nha!")
    @Size(min = 5, max = 45, message = "số ký tự phải nhiều hơn 5 và nhỏ hơn 45!")
    private String lastname;

    @NotNull(message = "Bắt buộc phỉa nhập nha! ")
    @Pattern(regexp = "(0[3|7|8|5|9])+([0-9]{8,9})$", message = "số bắt đầu bằng 0, và phải 10 hoặc 11 số")
    private String phoneNumber;

    @NotNull(message = "Bắt buộc phỉa nhập nha! ")
    @Min(value = 18, message = "Phải lớn hơn 18 tuổi mới vào được nha!")
    private Integer age;

    @NotNull(message = "Bắt buộc phải nhập nha! ")
    @NotBlank(message = "Không được để rỗng nha!")
    @Email(message = "mail phỉa đúng chuẩn mới đươc")
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
