package pl.laptopy.polizingowe.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListConverter<T> {

    public List<T> convertIterableToList(Iterable<T> iterableList) {
        List orderSummaryList = new ArrayList<>();
        iterableList.forEach(orderSummaryList::add);
        return orderSummaryList;
    }
}
