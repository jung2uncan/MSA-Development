package shopmall;

import shopmall.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyHandler{

    @Autowired
    OrderStatusRepository repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void when_CREATE_orderPlaced(@Payload OrderPlaced orderPlaced){
        if(orderPlaced.isMe()){
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setOrderId(orderPlaced.getId());
            orderStatus.setProductId(orderPlaced.getProductId());
            orderStatus.setQty(orderPlaced.getQty());
            orderStatus.setProductName(orderPlaced.getProductName());
            // 주문 상태를 이벤트의 클레스 명으로 입력 하여 준다.
            orderStatus.setOrderStatus(OrderPlaced.class.getSimpleName());
            repository.save(orderStatus);
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void when_UPDATE_DeliveryStarted(@Payload DeliveryStarted deliveryStarted){
        if(deliveryStarted.isMe()){
            OrderStatus orderStatus = repository.findById(deliveryStarted.getOrderId()).orElse(null);;
            if( orderStatus != null ){
                orderStatus.setDeliveryId(deliveryStarted.getId());
                orderStatus.setDeliveryStatus(DeliveryStarted.class.getSimpleName());
                repository.save(orderStatus);
            }
        }
    }

    //주문이 취소되었을 때도 Tracking 가능하도록 코드 보완
    @StreamListener(KafkaProcessor.INPUT)
    public void when_UPDATE_OrderCancelled(@Payload OrderCancelled orderCancelled){
        if(orderCancelled.isMe()){
            OrderStatus orderStatus = repository.findById(orderCancelled.getId()).orElse(null);;
            if( orderStatus != null ){
                orderStatus.setOrderStatus(OrderCancelled.class.getSimpleName());
                repository.save(orderStatus);
            }
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void when_UPDATE_DeliveryCancelled(@Payload DeliveryCancelled deliveryCancelled){
        if(deliveryCancelled.isMe()){
            OrderStatus orderStatus = repository.findById(deliveryCancelled.getOrderId()).orElse(null);;
            if( orderStatus != null ){
                orderStatus.setDeliveryStatus(DeliveryCancelled.class.getSimpleName());
                repository.save(orderStatus);
            }
        }
    }

}
