package pl.laptopy.polizingowe.service.impl;

import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.dto.OrderSummaryDto;
import pl.laptopy.polizingowe.entity.OrderSummary;
import pl.laptopy.polizingowe.mapper.OrderSummaryMapper;
import pl.laptopy.polizingowe.repository.OrderSummaryRepository;
import pl.laptopy.polizingowe.utils.ListConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Service
public class OrderSummaryService {
//
//    private final OrderSummaryMapper orderSummaryMapper;
//    private final ListConverter<OrderSummary> orderSummaryListConverter;
//    private final OrderSummaryRepository orderSummaryRepository;
//
//    public OrderSummaryService(OrderSummaryMapper orderSummaryMapper, ListConverter<OrderSummary> orderSummaryListConverter,
//                               OrderSummaryRepository orderSummaryRepository) {
//        this.orderSummaryMapper = orderSummaryMapper;
//        this.orderSummaryListConverter = orderSummaryListConverter;
//        this.orderSummaryRepository = orderSummaryRepository;
//    }
//
//    public List<OrderSummaryDto> findAllOrders() {
//        List<OrderSummary> orderSummaryList = orderSummaryListConverter.convertIterableToList(orderSummaryRepository.findAll());
//        return orderSummaryList.stream()
//                .map(orderSummaryMapper::mapToOrderSummaryDto)
//                .collect(Collectors.toList());
//    }
//
//    public OrderSummaryDto saveOrderSummary(OrderSummaryDto orderSummaryDto) {
//        OrderSummary orderSummary = orderSummaryMapper.mapToOrderSummary(orderSummaryDto);
//        orderSummaryRepository.save(Optional.of(orderSummary).orElseThrow(RuntimeException::new));
//        return orderSummaryDto;
//    }
//
//    public void deleteOrderSummaryById(Long orderSummaryId) {
//        orderSummaryRepository.deleteProduct(orderSummaryId);
//    }
}
