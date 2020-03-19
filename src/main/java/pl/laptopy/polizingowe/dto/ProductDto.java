package pl.laptopy.polizingowe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
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