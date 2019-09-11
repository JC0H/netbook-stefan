package pl.laptopy.polizingowe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date")
    @NotNull
    private Date orderDate;

    @NotEmpty(message = "No products added into order.")
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

//    @NotNull(message = "Customer wasn't provided.")
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<User> users;
}
