package lk.kdpm.pos_backend.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;


import java.util.ArrayList;
import java.util.List;

@Entity     //Entity ekak kiyala pennanna mee annotation eka daanawa.
@Table(name = "customer")   //DB Table eke name eka change kara ganna oona nam mee annotation eka use karnna puluwan.
//ArrayList ekak apita  nikamma use karanna denne na. ekata api JSON walin karanna thiinne. eekata JSON genalla daaganna oona.
//@TypeDefs({
//        @TypeDef(name= "json", typeClass = JsonType.class)
//})
public class Customer {

    @Id //Primary key ekak kiyala pennanna me annotation eka danawa
    @Column(name = "customer_id",length = 45)  //database ekee column ekee hadena name eka custurmize kara ganna puluwan mee annotation eken. saha  validation ekak dennath puluwan.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name",length = 100,nullable = false)  //name ekak nathiwa table ekata customer kenek add karanna bh.. meeka nathuwa nm daanna puluwan. ee nisa null karanne nathuwa thiyanna.
    private String customerName;

    @Column(name = "customer_address",length = 250)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    //eka customer kenekta contact numbers ekak hoo kipayak thiinnath puluwan.. eenisaa eekata api array list ekakata daala thiyanawa.
//    @Type(type = "json")
    @Type(JsonType.class)
    @Column(name = "contact_numbers", length = 12, columnDefinition = "json")
    private List<String> contactNumber;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_status",columnDefinition = "TINYINT default 0")
    private boolean active;


    //Alt + Insert gahala no args constructor & all args constructor eka daa ganna puluwan.
    public Customer() {
    }
    public Customer(int customerId, String customerName, String customerAddress, double customerSalary, List<String> contactNumber, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.active = active;
    }

    // Getters Setters dhamiimatath Alt + Insert walin kara ganna puluwan.


    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public List<String> getContactNumber() {
        return contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public void setContactNumber(List<String> contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

//    ToString ekath daa ganna puluwan. toString eken karanne api daapu okkoma data concat karala denawa. meka use karagena data print  kara gannawa wagee deewal kara ganna puluwan.

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", contactNumber=" + contactNumber +
                ", nic=" + nic +
                ", active=" + active +
                '}';
    }
}




