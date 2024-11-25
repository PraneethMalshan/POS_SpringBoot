package lk.kdpm.pos_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDetailsDTO {
//    Customer
    private String customerName;
    private String customerAddress;
    private List<String> contactNumber;
//    Order
    private Date date;
    private Double total;
}
