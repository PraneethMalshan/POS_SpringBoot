package lk.kdpm.pos_backend.dto.request;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lk.kdpm.pos_backend.entity.Item;
import lk.kdpm.pos_backend.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderDetailsSaveDTO {

    private String itemName;
    private double qty;
    private double amount;
    private int orders ;
    private int items;

}
