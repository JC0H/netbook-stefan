package pl.laptopy.polizingowe.mapper;

import org.springframework.stereotype.Component;
import pl.laptopy.polizingowe.dto.OrderSummaryDto;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Customer;
import pl.laptopy.polizingowe.entity.OrderSummary;
import pl.laptopy.polizingowe.entity.Product;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderSummaryMapper {

    private final ProductMapper productMapper;

    public OrderSummaryMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public OrderSummary mapToOrderSummary(OrderSummaryDto summaryDto) {
        return OrderSummary.builder()
                .orderDate(summaryDto.getOrderDate())
                .uuid(summaryDto.getUuid())
                .customer(Customer.builder()
                        .name(summaryDto.getCustomerName())
                        .email(summaryDto.getCustomerEmail())
                        .phoneNumber(summaryDto.getCustomerPhoneNumber())
                        .build())
                .products(summaryDto.getProducts().stream()
                        .map(productMapper::mapToProduct)
                        .collect(Collectors.toList())
                )
                .build();
    }

    public OrderSummaryDto mapToOrderSummaryDto(OrderSummary orderSummary) {
        Customer customer = orderSummary.getCustomer();
        return OrderSummaryDto.builder()
                .orderDate(orderSummary.getOrderDate())
                .customerEmail(customer.getEmail())
                .customerName(customer.getName())
                .customerPhoneNumber(customer.getPhoneNumber())
                .products(orderSummary.getProducts().stream()
                        .map(this::mapToProductDtoList)
                        .collect(Collectors.toList())
                )
                .build();
    }

    private ProductDto mapToProductDtoList(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .build();
    }
}
