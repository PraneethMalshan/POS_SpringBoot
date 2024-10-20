package lk.kdpm.pos_backend.util.mappers;

import lk.kdpm.pos_backend.dto.response.ItemGetResponseDTO;
import lk.kdpm.pos_backend.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<ItemGetResponseDTO> entityListTiDtoList(List<Item> items);

}


//ItemList -----> ItemResponseDTO
//entityListTiDtoList ---> Entity list ekak DTO list ekakata convert karanna thamaa yanne