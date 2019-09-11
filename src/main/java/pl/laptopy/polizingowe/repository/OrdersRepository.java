package pl.laptopy.polizingowe.repository;

import org.springframework.data.repository.CrudRepository;
import pl.laptopy.polizingowe.model.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
}
