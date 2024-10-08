package lk.kdpm.pos_backend.service.impl;

import lk.kdpm.pos_backend.dto.CustomerDTO;
import lk.kdpm.pos_backend.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        System.out.println(customerDTO.getCustomerAddress());
        return customerDTO.getCustomerName();
    }
}
