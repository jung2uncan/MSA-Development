package shopping.dto.event;

import java.util.Date;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long itemID;
    private Long orderID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getItemId() {
        return itemID;
    }

    public void setItemId(Long itemID) {
        this.itemID = itemID;
    }
    public Long getOrderId() {
        return orderID;
    }

    public void setOrderId(Long orderID) {
        this.orderID = orderID;
    }
}