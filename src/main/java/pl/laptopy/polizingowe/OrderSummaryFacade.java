package pl.laptopy.polizingowe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.laptopy.polizingowe.model.MailEntity;
import pl.laptopy.polizingowe.model.OrderSummary;
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
        MailEntity.builder()
                .message("someone made order, please check your mail")
                .subject("ordeer is made")
//                .receivers("link to page")
                .build();
        mailService.sendMail(MailEntity.builder()
                .message("someone made order, please check your mail")
                .subject("order is made")
//                .receivers("link to page")
                .build());
        return orderSummaryService.createOrder(orderSummary);
    }
}
