package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.config.PropertiesConfig;
import pl.laptopy.polizingowe.dto.OrderSummaryDto;
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

    @GetMapping
    public List<OrderSummaryDto> findAllOrders() {
        return orderSummaryFacade.findAllOrders();
    }

    @PostMapping
    public ResponseEntity makeOrder(@Valid @RequestBody OrderSummaryDto orderSummaryDto) {
        OrderSummaryDto createdOrder = orderSummaryFacade.createOrderAndSendConfirmation(orderSummaryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping
    public ResponseEntity updateOrder(@Valid @RequestBody OrderSummaryDto orderSummaryDto) {
        orderSummaryFacade.updateOrder(orderSummaryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderSummaryDto);
    }

    @DeleteMapping
    public ResponseEntity deleteOrder(@PathVariable Long orderId) {
        orderSummaryFacade.deleteOrder(orderId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}