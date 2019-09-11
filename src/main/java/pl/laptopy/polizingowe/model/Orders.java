package pl.laptopy.polizingowe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date")
    private Date orderDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<User> users;
}
