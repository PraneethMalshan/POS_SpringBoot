package lk.kdpm.pos_backend.dto;

import java.util.List;

public class CustomerDTO {

//    Layers athara data passkaranne meeken. controller ekata data enne meken. frontend eketh mee wagee ekak thiinna oona.
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private List<String> contactNumber;
    private double nic;
    private boolean active;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerName, String customerAddress, double customerSalary, List<String> contactNumber, double nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public List<String> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(List<String> contactNumber) {
        this.contactNumber = contactNumber;
    }

    public double getNic() {
        return nic;
    }

    public void setNic(double nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
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
