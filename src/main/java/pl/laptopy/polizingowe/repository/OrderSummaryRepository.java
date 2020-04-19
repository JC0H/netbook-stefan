package pl.laptopy.polizingowe.repository;

import org.springframework.data.repository.CrudRepository;
import pl.laptopy.polizingowe.entity.OrderSummary;

public interface OrderSummaryRepository extends CrudRepository<OrderSummary, Long> {
}
