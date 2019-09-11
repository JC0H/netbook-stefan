package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.laptopy.polizingowe.model.Orders;
import pl.laptopy.polizingowe.service.OrdersService;

import java.util.List;

@RestController
@RequestMapping(value = "orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping
    public List<Orders> findAllOrders() {
        return ordersService.findAllOrdersAndSortByDate();
    }

}
