package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.config.PropertiesConfig;
import pl.laptopy.polizingowe.entity.OrderSummary;
import pl.laptopy.polizingowe.facade.OrderSummaryFacade;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "${api.stefan.notebook}" + "/orders")
@RequiredArgsConstructor
public class OrderSummaryController {

    private final OrderSummaryFacade orderSummaryFacade;
    private final PropertiesConfig propertiesConfig;

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