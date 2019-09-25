package pl.laptopy.polizingowe.dto;

import pl.laptopy.polizingowe.model.ProductDetails;

import java.util.List;

public class ProductDTO {
    private Long Id;
    private String brand;
    private List<ProductDetails> productDetailsList;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String brand, List<ProductDetails> productDetailsList) {
        Id = id;
        this.brand = brand;
        this.productDetailsList = productDetailsList;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<ProductDetails> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<ProductDetails> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }
}
