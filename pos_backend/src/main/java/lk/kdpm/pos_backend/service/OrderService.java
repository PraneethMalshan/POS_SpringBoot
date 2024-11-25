package lk.kdpm.pos_backend.service;


import lk.kdpm.pos_backend.dto.paginated.PaginatedResponseOrderDetailsDTO;
import lk.kdpm.pos_backend.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    PaginatedResponseOrderDetailsDTO getAllOrderDetails(boolean status, int page, int size);
//    String saveOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}

