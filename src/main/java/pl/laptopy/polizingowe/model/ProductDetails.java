package pl.laptopy.polizingowe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "Please provide information about model.")
    @Column(name = "model")
    private String model;

    @NotEmpty(message = "Please provide information about processor.")
    @Column(name = "processor")
    private String processor;

    @NotEmpty(message = "Please provide information about graphics.")
    @Column(name = "graphics")
    private String graphics;

    @NotEmpty(message = "Please provide information about memory.")
    @Column(name = "memory")
    private String memory;

    @NotEmpty(message = "Please provide information about screen.")
    @Column(name = "screen")
    private String screen;

    @NotEmpty(message = "Please provide information about RAM.")
    @Column(name = "RAM")
    private String ram;

    @NotEmpty(message = "Please provide information about network.")
    @Column(name = "network")
    private String network;

    @NotEmpty(message = "Please provide information about color.")
    @Column(name = "color")
    private String color;

    @NotEmpty(message = "Please provide information about weight.")
    @Column(name = "weight")
    private double weight;

    @NotEmpty(message = "Please provide information about OS.")
    @Column(name = "operatingSystem")
    private String operatingSystem;

    @NotEmpty(message = "Please provide information about usb and ports.")
    @Column(name = "usb")
    private String usb;

    @Column(name = "additionalInformation")
    private String additionalInformation;

    @NotEmpty(message = "Please provide information about price.")
    @Min(100)
    @Column(name = "price")
    private double price;
}
