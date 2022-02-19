package shopping.dto.event;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderCancled extends AbstractEvent {

    private Long id;

    public OrderCancled(){
        super();
    }
}