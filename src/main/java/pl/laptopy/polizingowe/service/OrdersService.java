package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.model.Orders;
import pl.laptopy.polizingowe.repository.OrdersRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public List<Orders> findAllOrdersAndSortByDate() {
        List<Orders> ordersList = convertIterableToList(ordersRepository.findAll());
        ordersList.sort((Comparator.comparing(Orders::getOrderDate)));
        return ordersList;
    }

    private List<Orders> convertIterableToList(Iterable<Orders> orderIterable) {
        List<Orders> ordersList = new ArrayList<>();
        orderIterable.forEach(ordersList::add);
        return ordersList;
    }
}
