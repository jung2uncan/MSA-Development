package shopping.dto.event;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class InventoryIncresed extends AbstractEvent {

    private Long id;
    private Long itemId;
    private Integer inventory;

    public InventoryIncresed(){
        super();
    }
}