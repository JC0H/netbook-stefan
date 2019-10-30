package pl.laptopy.polizingowe.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTestServiceImpl implements ProductTestService {

    @Autowired
    ProductTestRepository employeeRepository;

    @Override
    public ProductTest createEmployee(ProductTest employee) {
        return employeeRepository.save(employee);

    }

    @Override
    public List<ProductTest> getAllEmployees() {
        return employeeRepository.findAll();
    }

}

