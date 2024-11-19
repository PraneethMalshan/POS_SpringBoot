package lk.kdpm.pos_backend.service;


import lk.kdpm.pos_backend.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
//    String saveOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}

