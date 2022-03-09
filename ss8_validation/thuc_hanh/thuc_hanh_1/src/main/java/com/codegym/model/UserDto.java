package com.codegym.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto {
    @NotEmpty(message = "Tên không nên để rỗng nha!")
    @Size(min = 2, max = 30, message = "Tên phải nhiều hơn 2 ký tự và ít hơn 30 ký tự nha!")
    private String name;
    @Min(value = 18, message = "Tuổi phải lớn hơn 18 mới trưởng thành được")
    private int age;

    public UserDto() {
    }

    public UserDto(@NotEmpty @Size(min = 2, max = 30) String name, @Min(18) int age) {
        this.name = name;
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
