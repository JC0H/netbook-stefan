package pl.laptopy.polizingowe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDetailsDto {

    private Long id;

    @NotEmpty(message = "Please provide information about model.")
    private String model;

    @NotEmpty(message = "Please provide information about processor.")
    private String processor;

    @NotEmpty(message = "Please provide information about graphics.")
    private String graphics;

    @NotEmpty(message = "Please provide information about memory.")
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
    private String color;

    @NotEmpty(message = "Please provide information about weight.")
    private double weight;

    @NotEmpty(message = "Please provide information about OS.")
    private String operatingSystem;

    @NotEmpty(message = "Please provide information about usb and ports.")
    private String usb;

    private String additionalInformation;

    @NotEmpty(message = "Please provide information about price.")
    @Min(100)
    private double price;
}
