package lk.kdpm.pos_backend.controller;


import lk.kdpm.pos_backend.dto.paginated.PaginatedResponseOrderDetailsDTO;
import lk.kdpm.pos_backend.dto.request.RequestOrderSaveDTO;
import lk.kdpm.pos_backend.service.OrderService;
import lk.kdpm.pos_backend.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){

        String id = orderService.addOrder(requestOrderSaveDTO);


        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, id + "Success",id),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            params = {"stateType","page","size"},
            path = {"/get-order-details"}
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
//            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(value = "size") int size
    ){
        PaginatedResponseOrderDetailsDTO p = null;
        if (stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")){
            boolean status = stateType.equalsIgnoreCase("active") ? true : false;
            p = orderService.getAllOrderDetails(status,page,size);
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "SUCCESS!",p),
                HttpStatus.OK
        );

    }

}
