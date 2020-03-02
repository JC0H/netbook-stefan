package pl.laptopy.polizingowe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

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

    @Lob
    private Byte[] image;
}
