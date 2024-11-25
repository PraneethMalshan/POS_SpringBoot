package lk.kdpm.pos_backend.dto.paginated;

import lk.kdpm.pos_backend.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetailsDTO {
    private List<ResponseOrderDetailsDTO> list;
    private long dataCount;
}
