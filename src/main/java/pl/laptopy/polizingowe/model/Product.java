package pl.laptopy.polizingowe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    @NotEmpty(message = "Please provide a brand.")
    private String brand;

    @NotEmpty(message = "Properties field is empty.")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Properties> propertiesList;

}
