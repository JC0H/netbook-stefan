package pl.laptopy.polizingowe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "processor")
    private String processor;

    @Column(name = "graphics")
    private String graphics;

    @Column(name = "memory")
    private String memory;

    @Column(name = "screen")
    private String screen;

    @Column(name = "RAM")
    private String ram;

    @Column(name = "network")
    private String network;

    @Column(name = "color")
    private String color;

    @Column(name = "weight")
    private String weight;

    @Column(name = "operatingSystem")
    private String operatingSystem;

    @Column(name = "usb")
    private String usb;

    @Column(name = "additionalInformation")
    private String additionalInformation;

    @Column(name = "price")
    private String price;

}
