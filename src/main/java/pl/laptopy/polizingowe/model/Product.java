package pl.laptopy.polizingowe.model;

import lombok.*;
import pl.laptopy.polizingowe.model.domain.AbstractDomainClass;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends AbstractDomainClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "brand")
    private String brand;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Properties> propertiesList;

}
