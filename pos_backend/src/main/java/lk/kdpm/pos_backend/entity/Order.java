package lk.kdpm.pos_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "orders")
/*@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @Column(name = "order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date date;

}
