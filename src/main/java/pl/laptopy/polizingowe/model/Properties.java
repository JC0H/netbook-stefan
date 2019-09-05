package pl.laptopy.polizingowe.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "properties")
@Getter
@Setter
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "processor")
    private String processor;

    @Column(name = "graphics")
    private String graphics;

    @Column(name = "memory")
    private String memory;

    @Column(name = "screen")
    private String screen;

    @Column(name = "HardDriveCapacity")
    private String HardDriveCapacity;

    @Column(name = "RAM")
    private String RAM;

    @Column(name = "network")
    private String network;

    @Column(name = "color")
    private String color;

    @Column(name = "weight")
    private double weight;

    @Column(name = "operatingSystem")
    private String operatingSystem;

    @Column(name = "usb")
    private String usb;

    @Column(name = "additionalInformation")
    private String additionalInformation;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
