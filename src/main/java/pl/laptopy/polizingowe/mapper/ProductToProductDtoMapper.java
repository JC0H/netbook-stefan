package pl.laptopy.polizingowe.mapper;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;

@Component
public class ProductToProductDtoMapper implements Converter<Product, ProductDto> {
    @Synchronized
    @Nullable
    @Override
    public ProductDto convert(Product source) {
        if (source == null) {
            return null;
        }

        final ProductDto product = new ProductDto();
        product.setId(source.getId());
        product.setBrand(source.getBrand());
        product.setModel(source.getModel());
        product.setProcessor(source.getProcessor());
        product.setGraphics(source.getGraphics());
        product.setMemory(source.getMemory());
        product.setScreen(source.getScreen());
        product.setRam(source.getRam());
        product.setNetwork(source.getNetwork());
        product.setColor(source.getColor());
        product.setWeight(source.getWeight());
        product.setOperatingSystem(source.getOperatingSystem());
        product.setUsb(source.getUsb());
        product.setAdditionalInformation(source.getAdditionalInformation());
        product.setPrice(source.getPrice());
        product.setImage(source.getImage());
        return product;
    }
}
