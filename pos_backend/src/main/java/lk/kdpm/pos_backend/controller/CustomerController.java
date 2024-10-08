package lk.kdpm.pos_backend.controller;

import lk.kdpm.pos_backend.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController    //Mee annotation eken thamayi meeka controller ekak kiyala define karanne. meyaagen thamayi client server architecture eka naththam REST API hadanna puluwan hakiyaawa labenne mee annotation eken. ee kiyanne meeken thamayi request ekak yawala response ekak ganna puluwan hakiyawa labenne.
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @PostMapping("save1")    //me method eka post/save method ekak nisaa mee annotation eka daanawa.
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){   //frontend ekee idala  ena request eka JSON Object ekak widiyata. eeka apee project eka aethule use karanna nam class type eka bawata bind kara ganna oona.(saralawa kiyanawa nm JSON object ekaka idala DTO ekata bind/convert kara ganna oona.) (Json walin aapu object eka DTO ekee class type ekata bine kara gannawa.->CustomerDTO)

        return "";

    }

}

//post - save
//get - search
//put - update
//delete - delete

//1. JSON widhiyata ena request ekak kohomadha api spring project eka aethule ape class type ekata bind kara ganne? @RequestBody annotation eken.