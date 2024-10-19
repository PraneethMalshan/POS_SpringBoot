package lk.kdpm.pos_backend.service.impl;

import lk.kdpm.pos_backend.dto.request.ItemRequestDTO;
import lk.kdpm.pos_backend.dto.response.ItemGetResponseDTO;
import lk.kdpm.pos_backend.entity.Customer;
import lk.kdpm.pos_backend.entity.Item;
import lk.kdpm.pos_backend.repo.ItemRepo;
import lk.kdpm.pos_backend.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo ;
    @Autowired
    private ModelMapper modelMapper ;

    @Override
    public String saveItem(ItemRequestDTO itemRequestDTO) {
//        Item item = new Item(
//                1,
//                itemRequestDTO.getItemName(),
//                itemRequestDTO.getMeasuringUnitType(),
//                itemRequestDTO.getBalanceQty(),
//                itemRequestDTO.getSupplierPrice(),
//                itemRequestDTO.getSellingPrice(),
//                true
//
//        );
//        itemRepo.save(item);
//        return itemRequestDTO.getItemName();
        Item item = modelMapper.map(itemRequestDTO, Item.class);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemId()+ "Saved successfully!";
        }else {
            throw new DuplicateKeyException("Already Added!");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {

//        List<Item> items = itemRepo.ujdjjjbhvdh(itemName, true);
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Item is not Active!");
        }

    }
}

