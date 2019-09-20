package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.OrderSummaryFacade;
import pl.laptopy.polizingowe.model.OrderSummary;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "${api.stefan.notebook}" + "/orders")
@RequiredArgsConstructor
public class OrderSummaryController {

    private final OrderSummaryFacade orderSummaryFacade;

    @GetMapping
    public List<OrderSummary> findAllOrders() {
        return orderSummaryFacade.findAllOrders();
    }

    @PostMapping
    public ResponseEntity makeOrder(@Valid @RequestBody OrderSummary orderSummary) {
        OrderSummary createdOrderSummary = orderSummaryFacade.createOrderAndSendConfirmation(orderSummary);
        return ResponseEntity.status(200).body(createdOrderSummary);
    }
}
