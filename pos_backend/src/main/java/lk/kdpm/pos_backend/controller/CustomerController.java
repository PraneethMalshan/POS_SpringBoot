package lk.kdpm.pos_backend.controller;

import lk.kdpm.pos_backend.dto.CustomerDTO;
import lk.kdpm.pos_backend.dto.request.CustomerUpdateDTO;
import lk.kdpm.pos_backend.service.CustomerService;
import lk.kdpm.pos_backend.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    //Mee annotation eken thamayi meeka controller ekak kiyala define karanne. meyaagen thamayi client server architecture eka naththam REST API hadanna puluwan hakiyaawa labenne mee annotation eken. ee kiyanne meeken thamayi request ekak yawala response ekak ganna puluwan hakiyawa labenne.
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService ;

    @PostMapping("/save")    //me method eka post/save method ekak nisaa mee annotation eka daanawa.
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){   //frontend ekee idala  ena request eka JSON Object ekak widiyata. eeka apee project eka aethule use karanna nam class type eka bawata bind kara ganna oona.(saralawa kiyanawa nm JSON object ekaka idala DTO ekata bind/convert kara ganna oona.) (Json walin aapu object eka DTO ekee class type ekata bine kara gannawa.->CustomerDTO)

        customerService.saveCustomer(customerDTO);
        return "saved";

    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message = customerService.updateCustomer(customerUpdateDTO);
        return message;
        //        return "updated";

    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){

        CustomerDTO customerDTO = customerService.getCustomerById(customerId);

        //        System.out.println("Print Value "+customerId);
        return customerDTO;
    }

//    @GetMapping(
//            path = "/get-all-customers"
//
//    )
//    public List<CustomerDTO> getAllCustomers(){
//        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
//        return allCustomers;
//    }

    @GetMapping(
            path = "/get-all-customers"

    )
    public ResponseEntity<StandardResponse> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success",allCustomers),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String delete = customerService.deleteCustomer(customerId);
        return delete;
    }

    @GetMapping(path = "/get-all-customers-by-active-state/{status}")
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState){
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;
    }

}

//post - save
//get - search
//put - update
//delete - delete

