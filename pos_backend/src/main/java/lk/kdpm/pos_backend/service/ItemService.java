package lk.kdpm.pos_backend.service;

import lk.kdpm.pos_backend.dto.request.ItemRequestDTO;

public interface ItemService {
    String saveItem(ItemRequestDTO itemRequestDTO);
}
