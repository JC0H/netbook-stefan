package pl.laptopy.polizingowe.mapper;

import org.springframework.stereotype.Component;
import pl.laptopy.polizingowe.dto.ProductDetailsDto;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;
import pl.laptopy.polizingowe.entity.ProductDetails;

import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product mapToProduct(ProductDto productDto) {
        return Product.builder()
                .brand(productDto.getBrand())
                .productDetails(
                        productDto.getProductDetails().stream()
                                .map(this::mapToProductDetails)
                                .collect(Collectors.toList())
                )
                .build();
    }

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .brand(product.getBrand())
                .productDetails(
                        product.getProductDetails().stream()
                                .map(this::mapToProductDetailsDto)
                                .collect(Collectors.toList())
                )
                .build();
    }

    private ProductDetails mapToProductDetails(ProductDetailsDto productDetailsDto) {
        return ProductDetails.builder()
                .id(productDetailsDto.getId())
                .model(productDetailsDto.getModel())
                .processor(productDetailsDto.getProcessor())
                .graphics(productDetailsDto.getGraphics())
                .memory(productDetailsDto.getMemory())
                .screen(productDetailsDto.getScreen())
                .ram(productDetailsDto.getRam())
                .network(productDetailsDto.getNetwork())
                .color(productDetailsDto.getColor())
                .weight(productDetailsDto.getWeight())
                .operatingSystem(productDetailsDto.getOperatingSystem())
                .usb(productDetailsDto.getUsb())
                .additionalInformation(productDetailsDto.getAdditionalInformation())
                .price(productDetailsDto.getPrice())
                .build();
    }

    private ProductDetailsDto mapToProductDetailsDto(ProductDetails productDetails) {
        return ProductDetailsDto.builder()
                .id(productDetails.getId())
                .model(productDetails.getModel())
                .processor(productDetails.getProcessor())
                .graphics(productDetails.getGraphics())
                .memory(productDetails.getMemory())
                .screen(productDetails.getScreen())
                .ram(productDetails.getRam())
                .network(productDetails.getNetwork())
                .color(productDetails.getColor())
                .weight(productDetails.getWeight())
                .operatingSystem(productDetails.getOperatingSystem())
                .usb(productDetails.getUsb())
                .additionalInformation(productDetails.getAdditionalInformation())
                .price(productDetails.getPrice())
                .build();
    }
}
