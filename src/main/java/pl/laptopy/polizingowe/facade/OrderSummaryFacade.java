package pl.laptopy.polizingowe.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.laptopy.polizingowe.dto.OrderSummaryDto;
import pl.laptopy.polizingowe.service.impl.MailService;
import pl.laptopy.polizingowe.service.impl.OrderSummaryService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderSummaryFacade {

    private final OrderSummaryService orderSummaryService;
    private final MailService mailService;

    public List<OrderSummaryDto> findAllOrders() {
        return orderSummaryService.findAllOrders();
    }

    public OrderSummaryDto createOrderAndSendConfirmation(OrderSummaryDto orderSummaryDto) {
        mailService.sendMailNotification(orderSummaryDto);
        return orderSummaryService.saveOrderSummary(orderSummaryDto);
    }
}
