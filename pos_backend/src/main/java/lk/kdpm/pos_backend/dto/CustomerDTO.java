package lk.kdpm.pos_backend.dto;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import org.hibernate.annotations.Type;

import java.util.List;

public class CustomerDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private List<String> contactNumber;
    private double nic;
    private boolean activeState;



}
