package pl.laptopy.polizingowe.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListConverter<T> {

    public List<T> convertIterableToList(Iterable<T> iterableList) {
        List<T> orderSummaryList = new ArrayList<>();
        iterableList.forEach(orderSummaryList::add);
        return orderSummaryList;
    }

    public String[] convertListToArray(List<String> entryList) {
        int size = entryList.size();
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = entryList.get(i);
        }
        return array;
    }
}
