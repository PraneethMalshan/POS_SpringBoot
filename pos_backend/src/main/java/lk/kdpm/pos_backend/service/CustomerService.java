package lk.kdpm.pos_backend.service;

import lk.kdpm.pos_backend.dto.CustomerDTO;
import lk.kdpm.pos_backend.dto.request.CustomerUpdateDTO;

public interface CustomerService {

    public String saveCustomer(CustomerDTO customerDTO );

    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

}
