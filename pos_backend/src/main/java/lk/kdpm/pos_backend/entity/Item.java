package lk.kdpm.pos_backend.entity;
import lk.kdpm.pos_backend.entity.enums.measuringUnitType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
//@Getter  //getters tika daa ganna oonanm
//@Setter  //setters tika daa ganna oona nm
//@ToString  //ToString method eka daa ganna oona nm
@Data  //@Getter @Setter @ToString yana thunama meeken daanna puluwan.
public class Item {

    @Id
    @Column(name = "Item_Id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "meassure_type",length = 100,nullable = false)
    private measuringUnitType measuringUnitType;

    @Column(name = "balance_qty",length = 100,nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",length = 100,nullable = false)
    private double sellingPrice;

    @Column(name = "active_status",columnDefinition = "TINYINT default 0")
    private boolean activeState;
}