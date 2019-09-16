package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.model.OrderSummary;
import pl.laptopy.polizingowe.repository.OrderSummaryRepository;
import pl.laptopy.polizingowe.utils.ListConverter;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderSummaryService {

    private final ListConverter<OrderSummary> orderSummaryListConverter;
    private final OrderSummaryRepository orderSummaryRepository;

    public List<OrderSummary> findAllOrdersAndSortByDate() {
        List<OrderSummary> orderSummaryList = orderSummaryListConverter.convertIterableToList(orderSummaryRepository.findAll());
        orderSummaryList.sort((Comparator.comparing(OrderSummary::getOrderDate)));
        return orderSummaryList;
    }
}
