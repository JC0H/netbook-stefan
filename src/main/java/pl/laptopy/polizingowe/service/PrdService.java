package pl.laptopy.polizingowe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.laptopy.polizingowe.dto.ProductDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrdService {
    @Value("${resource.products}")
    private String resource;
    @Value("${resource.products}/{id}")
    private String idResource;
    @Autowired
    private RestTemplate restTemplate;

    public List<ProductDTO> findAll() {
        return Arrays.stream(restTemplate.getForObject(resource, ProductDTO[].class)).collect(Collectors.toList());
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {
        return restTemplate.exchange(idResource, HttpMethod.PUT, new HttpEntity<>(productDTO), ProductDTO.class, id).getBody();
    }

    public void delete(Long id) {
        restTemplate.delete(idResource, id);
    }

    public ProductDTO create(ProductDTO task) {
        return restTemplate.postForObject(resource, task, ProductDTO.class);
    }
}
