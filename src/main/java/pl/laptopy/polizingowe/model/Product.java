package pl.laptopy.polizingowe.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    @NotEmpty(message = "Please provide a brand.")
    private String brand;

   // @NotEmpty(message = "Properties field is empty.")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductDetails> productDetailsList;

    public Product() {
    }

    public Product(@NotEmpty(message = "Please provide a brand.") String brand,
                   @NotEmpty(message = "Properties field is empty.") List<ProductDetails> productDetailsList) {
        this.brand = brand;
        this.productDetailsList = productDetailsList;
    }

    public Product(Long id) {

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
