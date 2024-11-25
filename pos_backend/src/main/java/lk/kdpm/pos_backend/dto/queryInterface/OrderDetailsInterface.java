package lk.kdpm.pos_backend.dto.queryInterface;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailsInterface {
    //    Customer
    String getCustomerName();
    String getCustomerAddress();
    ArrayList getContactNumber();

    //    Order
    Date getDate();
    Double getTotal();
}
