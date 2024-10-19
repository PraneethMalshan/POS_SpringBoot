package lk.kdpm.pos_backend.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.kdpm.pos_backend.entity.enums.measuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDTO {

    private int itemId;
    private String itemName;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;

}
