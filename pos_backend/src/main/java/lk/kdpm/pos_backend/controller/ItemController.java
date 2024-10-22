package lk.kdpm.pos_backend.controller;

import lk.kdpm.pos_backend.dto.CustomerDTO;
import lk.kdpm.pos_backend.dto.paginated.PaginatedResponseItemDTO;
import lk.kdpm.pos_backend.dto.request.ItemRequestDTO;
import lk.kdpm.pos_backend.dto.response.ItemGetResponseDTO;
import lk.kdpm.pos_backend.service.ItemService;
import lk.kdpm.pos_backend.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService ;

 /*   @PostMapping(path = {"/save"})
    public String saveItem(@RequestBody ItemRequestDTO itemRequestDTO){

        String message = itemService.saveItem(itemRequestDTO);
        return "saved";

    }*/

    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemRequestDTO itemRequestDTO){

        String message = itemService.saveItem(itemRequestDTO);

/*        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success",message), HttpStatus.CREATED
        );
        return response;*/
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success",message),
                HttpStatus.CREATED
        );


    }

    @GetMapping(path = "/get-by-name", params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemDTOS;
    }

    @GetMapping(path = "/get-by-name-with-mapstruct", params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapStruct(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatusByMapStruct(itemName);
        return itemDTOS;
    }


    /*@GetMapping(path = "/get-by-item-by-status", params = "activeStatus")
    public ResponseEntity<StandardResponse> getItemsByActiveStatus(@RequestParam(value = "activeStatus") boolean activeStatus){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemsByActiveStatus(activeStatus);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success",itemDTOS),
                HttpStatus.OK
        );
    }*/

    @GetMapping(
            path = "/get-by-item-by-status",
            params = {"activeStatus","page","size"})
    public ResponseEntity<StandardResponse> getItemsByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
//            @RequestParam(value = "size") @Max(50)int size //meeka danna validation ekak widiyata. New version ekee @Max annotation eka naa. old versions wala thiinawa(javax wala thinawa)
    ){
//        List<ItemGetResponseDTO> itemDTOS = itemService.getItemsByActiveStatus(activeStatus);
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemByActiveStatusWithPagination(activeStatus,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success",paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }


}
