package pl.laptopy.polizingowe.mapper;

import org.springframework.stereotype.Component;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;

@Component
public class ProductMapper {

    public Product mapToProduct(ProductDto productDto) {
        return Product.builder()
                .brand(productDto.getBrand())
                .id(productDto.getId())
                .model(productDto.getModel())
                .processor(productDto.getProcessor())
                .graphics(productDto.getGraphics())
                .memory(productDto.getMemory())
                .screen(productDto.getScreen())
                .ram(productDto.getRam())
                .network(productDto.getNetwork())
                .color(productDto.getColor())
                .weight(productDto.getWeight())
                .operatingSystem(productDto.getOperatingSystem())
                .usb(productDto.getUsb())
                .additionalInformation(productDto.getAdditionalInformation())
                .price(productDto.getPrice())
                .productPicPath(productDto.getProductPicPath())
                .build();
    }

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .brand(product.getBrand())
                .id(product.getId())
                .model(product.getModel())
                .processor(product.getProcessor())
                .graphics(product.getGraphics())
                .memory(product.getMemory())
                .screen(product.getScreen())
                .ram(product.getRam())
                .network(product.getNetwork())
                .color(product.getColor())
                .weight(product.getWeight())
                .operatingSystem(product.getOperatingSystem())
                .usb(product.getUsb())
                .additionalInformation(product.getAdditionalInformation())
                .price(product.getPrice())
                .productPicPath(product.getProductPicPath())
                .build();
    }
}
