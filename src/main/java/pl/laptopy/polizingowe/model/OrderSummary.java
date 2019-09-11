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
@Table(name = "order_summary")
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

    @NotEmpty(message = "Please provide a customer.")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Customer> customers;
}
