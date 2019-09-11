package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.model.OrderSummary;
import pl.laptopy.polizingowe.repository.OrderSummaryRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderSummaryService {

    private final OrderSummaryRepository orderSummaryRepository;

    public List<OrderSummary> findAllOrdersAndSortByDate() {
        List<OrderSummary> orderSummaryList = convertIterableToList(orderSummaryRepository.findAll());
        orderSummaryList.sort((Comparator.comparing(OrderSummary::getOrderDate)));
        return orderSummaryList;
    }

    private List<OrderSummary> convertIterableToList(Iterable<OrderSummary> orderIterable) {
        List<OrderSummary> orderSummaryList = new ArrayList<>();
        orderIterable.forEach(orderSummaryList::add);
        return orderSummaryList;
    }
}
