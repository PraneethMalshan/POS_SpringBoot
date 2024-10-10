package lk.kdpm.pos_backend.service.impl;

import lk.kdpm.pos_backend.dto.CustomerDTO;
import lk.kdpm.pos_backend.dto.request.CustomerUpdateDTO;
import lk.kdpm.pos_backend.entity.Customer;
import lk.kdpm.pos_backend.repo.CustomerRepo;
import lk.kdpm.pos_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo ;
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return  customerUpdateDTO.getCustomerName() + " Updated Successful!";

        }else {
            throw  new RuntimeException("No data found for that ID");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;
        }else {
            throw new RuntimeException("No Customer!");
        }

    }
}
