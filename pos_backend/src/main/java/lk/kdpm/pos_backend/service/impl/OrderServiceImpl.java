package lk.kdpm.pos_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.kdpm.pos_backend.dto.CustomerDTO;
import lk.kdpm.pos_backend.dto.paginated.PaginatedResponseOrderDetailsDTO;
import lk.kdpm.pos_backend.dto.queryInterface.OrderDetailsInterface;
import lk.kdpm.pos_backend.dto.request.RequestOrderSaveDTO;
import lk.kdpm.pos_backend.dto.response.ResponseOrderDetailsDTO;
import lk.kdpm.pos_backend.entity.Order;
import lk.kdpm.pos_backend.entity.OrderDetails;
import lk.kdpm.pos_backend.repo.CustomerRepo;
import lk.kdpm.pos_backend.repo.ItemRepo;
import lk.kdpm.pos_backend.repo.OrderDetailRepo;
import lk.kdpm.pos_backend.repo.OrderRepo;
import lk.kdpm.pos_backend.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional  //Transaction ekak thiinakota daana annotation eka.
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo ;
    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    private CustomerRepo customerRepo ;
    @Autowired
    private OrderDetailRepo orderDetailRepo ;
    @Autowired
    private ItemRepo itemRepo ;

    @Transactional
    @Override
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(
            customerRepo.getById(requestOrderSaveDTO.getCustomers()),
            requestOrderSaveDTO.getDate(),
            requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())){
//            List<OrderDetails> orderDetails = new ArrayList<>();
            List<OrderDetails> orderDetails = modelMapper.
                    map(requestOrderSaveDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>(){

                    }.getType());

            for (int i=0; i<orderDetails.size(); i++){
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }

            if (orderDetails.size()>0){
                orderDetailRepo.saveAll(orderDetails);
            }
            return "Saved!";
        }

        return null;
    }

    @Override
    public PaginatedResponseOrderDetailsDTO getAllOrderDetails(boolean status, int page, int size) {
        List<OrderDetailsInterface> orderDetailsDTOS = orderRepo.getAllOrderDetails(status, PageRequest.of(page,size));

//        System.out.println("Come "+orderDetailsDTOS.get(0).getCustomerName());
        List<ResponseOrderDetailsDTO>list = new ArrayList<>();
        for (OrderDetailsInterface o: orderDetailsDTOS){
            ResponseOrderDetailsDTO r = new ResponseOrderDetailsDTO(
                    o.getCustomerName(),
                    o.getCustomerAddress(),
                    o.getContactNumber(),
                    o.getDate(),
                    o.getTotal()
            );
            list.add(r);
        }
        PaginatedResponseOrderDetailsDTO paginatedResponseOrderDetailsDTO  = new PaginatedResponseOrderDetailsDTO(
            list,
            orderRepo.countAllOrderDetails(status)
        );
        return paginatedResponseOrderDetailsDTO;
    }


}
