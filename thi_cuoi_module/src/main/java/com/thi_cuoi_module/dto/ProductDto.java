package com.thi_cuoi_module.dto;

import com.thi_cuoi_module.model.ProductType;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDto {

    private Integer idProduct;

    @NotNull(message = "Bắt buộc phải nhập!")
    @NotBlank(message = "Không được để trống!")
    @Size(min = 5, max = 50, message = "Tên sản phẩm phải từ 5 đến 50 ký tự")
    private String nameProduct;
    @Min(value = 100, message = "giá tiền nghỏ nhất là 100.000 VND!")
    private String price;

    @NotNull(message = "Bắt buộc phải nhập!")
    @NotBlank(message = "Không được để trống!")
    private String status;

    @Valid
    private ProductType productType;

    public ProductDto() {
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
