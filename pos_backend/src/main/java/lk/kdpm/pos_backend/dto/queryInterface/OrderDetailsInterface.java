package lk.kdpm.pos_backend.dto.queryInterface;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailsInterface {
    //type method ekak kara ganiima. class wala wage interface wala variable hadanna ba. method witharayine hadanna puluwan. ee nisa variables tika method walin thiyanna oona nisa mewa type methods karala mehema daanna puluwan.

    //    Customer
    String getCustomerName();
    String getCustomerAddress();
    ArrayList getContactNumber();

    //    Order
    Date getDate();
    Double getTotal();
}
