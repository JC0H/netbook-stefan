package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.model.OrderSummary;
import pl.laptopy.polizingowe.service.OrderSummaryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "${app.stefan.notebook}" + "/orders")
@RequiredArgsConstructor
public class OrderSummaryController {

    private final OrderSummaryService orderSummaryService;

    @GetMapping
    public List<OrderSummary> findAllOrders() {
        return orderSummaryService.findAllOrdersAndSortByDate();
    }

    @PostMapping
    public OrderSummary makeOrder(@Valid @RequestBody OrderSummary orderSummary) {
        return orderSummary;
    }
}
