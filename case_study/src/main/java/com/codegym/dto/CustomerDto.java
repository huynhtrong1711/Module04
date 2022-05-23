package com.codegym.dto;

import com.codegym.model.customer.CustomerType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDto {

    private Integer customerId;

    @NotBlank(message = "Mã khách hàng không được để trống nha!")
    @Pattern(regexp = "^[KH-]+[0-9]{4}", message = "Mã khách hàng phải đúng mới quy định!")
    private String customerCode;

    @NotNull(message = "Tên khách hàng bắt buộc phải nhập!")
    @NotBlank(message = "Tên khách hàng không được để trống nha!")
    private String customerName;

    @NotNull(message = "Ngày sinh khách hàng bắt buộc phải nhập!")
    @NotBlank(message = "Ngày sinh khách hàng không được để trống nha!")
    private String customerBirthday;

    private boolean customerGender;

    @NotNull(message = "Bắt buộc phải nhập nha!")
    @NotBlank(message = "Không được để trống nha!")
    @Pattern(regexp = "[0-9]{9,12}", message = "CMNH phải đúng quy định nha!")
    private String customerIdCard;

    @NotNull(message = "Bắt buộc phỉa nhập nha! ")
    @NotBlank(message = "Không được để trống nha!")
    @Pattern(regexp = "(0[3|7|8|5|9])+([0-9]{8,9})$", message = "số bắt đầu bằng 0, và phải 10 hoặc 11 số")
    private String customerPhone;

    @NotNull(message = "Bắt buộc phải nhập nha! ")
    @NotBlank(message = "Không được để rỗng nha!")
    @Email(message = "Mail phải đúng chuẩn mới đươc")
    private String customerEmail;

    @NotNull(message = "Bắt buộc phải nhập nha! ")
    @NotBlank(message = "Không được để rỗng nha!")
    private String customerAddress;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
