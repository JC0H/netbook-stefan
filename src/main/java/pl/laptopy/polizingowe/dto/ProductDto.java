package pl.laptopy.polizingowe.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String brand;
    private String model;
    private String processor;
    private String graphics;
    private String memory;
    private String screen;
    private String ram;
    private String network;
    private String color;
    private String weight;
    private String operatingSystem;
    private String usb;
    private String additionalInformation;
    private String price;
    private Byte[] image;
}