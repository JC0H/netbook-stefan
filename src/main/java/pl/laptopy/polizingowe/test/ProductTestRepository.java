package pl.laptopy.polizingowe.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTestRepository extends JpaRepository<ProductTest, Long> {

}
