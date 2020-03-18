package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.dto.OrderSummaryDto;
import pl.laptopy.polizingowe.facade.OrderSummaryFacade;

import javax.validation.Valid;
import java.util.List;

//@Controller
//@RequiredArgsConstructor
//@RequestMapping(value = "${stefan.notebook}" + "/orders")
public class OrderSummaryController {

//    private final OrderSummaryFacade orderSummaryFacade;

//    @GetMapping
//    public List<OrderSummaryDto> findAllOrders() {
//        return orderSummaryFacade.findAllOrders();
//    }
//
//    @PostMapping
//    public ResponseEntity makeOrder(@Valid @RequestBody OrderSummaryDto orderSummaryDto) {
//        OrderSummaryDto createdOrder = orderSummaryFacade.createOrderAndSendConfirmation(orderSummaryDto);
//        return ResponseEntity.status(200).body(createdOrder);
//    }
}