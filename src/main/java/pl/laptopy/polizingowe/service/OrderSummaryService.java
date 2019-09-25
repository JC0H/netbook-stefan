package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.entity.OrderSummary;
import pl.laptopy.polizingowe.repository.OrderSummaryRepository;
import pl.laptopy.polizingowe.utils.ListConverter;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

    public OrderSummary saveOrderSummary(OrderSummary orderSummary) {
        return orderSummaryRepository.save(Optional.of(orderSummary).orElseThrow(RuntimeException::new));
    }

    public void deleteOrderSummaryById(Long orderSummaryId) {
        orderSummaryRepository.deleteById(orderSummaryId);
    }
}
