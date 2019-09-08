package pl.laptopy.polizingowe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Properties> propertiesList;

}
