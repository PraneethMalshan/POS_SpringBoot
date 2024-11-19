package lk.kdpm.pos_backend.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lk.kdpm.pos_backend.entity.Customer;
import lk.kdpm.pos_backend.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderSaveDTO {

    private int customers;
    private Date date;
    private Double total;
    private List<RequestOrderDetailsSaveDTO> orderDetails ;


}
