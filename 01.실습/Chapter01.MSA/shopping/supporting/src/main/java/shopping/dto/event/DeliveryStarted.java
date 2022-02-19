package shopping.dto.event;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long itemId;
    private Long orderId;

    public DeliveryStarted(){
        super();
    }
}