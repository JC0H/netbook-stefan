package pl.laptopy.polizingowe.mapper;

import org.springframework.stereotype.Component;
import pl.laptopy.polizingowe.dto.OrderSummaryDto;
import pl.laptopy.polizingowe.entity.Customer;
import pl.laptopy.polizingowe.entity.OrderSummary;

import java.util.UUID;

@Component
public class OrderSummaryMapper {

    public OrderSummary mapToOrderSummary(OrderSummaryDto summaryDto) {
        return OrderSummary.builder()
                .orderDate(summaryDto.getOrderDate())
                .uuid(generateUuid())
                .customer(Customer.builder()
                        .name(summaryDto.getCustomerName())
                        .email(summaryDto.getCustomerEmail())
                        .phoneNumber(summaryDto.getCustomerPhoneNumber())
                        .build())
                // TODO add products!!!
                .build();
    }

    public OrderSummaryDto mapToOrderSummaryDto(OrderSummary orderSummary) {
        Customer customer = orderSummary.getCustomer();
        return OrderSummaryDto.builder()
                 .orderDate(orderSummary.getOrderDate())
                .customerEmail(customer.getEmail())
                .customerName(customer.getName())
                .customerPhoneNumber(customer.getPhoneNumber())
                .build();
    }

    private String generateUuid() {
        return UUID.randomUUID().toString();
    }

}
