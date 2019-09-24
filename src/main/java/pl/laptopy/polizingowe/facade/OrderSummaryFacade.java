package pl.laptopy.polizingowe.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.laptopy.polizingowe.entity.OrderSummary;
import pl.laptopy.polizingowe.service.MailService;
import pl.laptopy.polizingowe.service.OrderSummaryService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderSummaryFacade {

    private final OrderSummaryService orderSummaryService;
    private final MailService mailService;

    public List<OrderSummary> findAllOrders() {
        return orderSummaryService.findAllOrdersAndSortByDate();
    }

    public OrderSummary createOrderAndSendConfirmation(OrderSummary orderSummary) {
        mailService.sendMailNotification(orderSummary);
        return orderSummaryService.saveOrderSummary(orderSummary);
    }
}
