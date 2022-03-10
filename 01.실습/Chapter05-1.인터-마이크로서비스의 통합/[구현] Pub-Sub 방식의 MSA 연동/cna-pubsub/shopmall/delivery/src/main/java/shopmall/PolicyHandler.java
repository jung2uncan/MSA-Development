package shopmall;

import shopmall.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderPlaced_StartDelivery(@Payload OrderPlaced orderPlaced){
        
        if(orderPlaced.isMe()){
            System.out.println("##### listener StartDelivery : " + orderPlaced.toJson());

            //발행된 이벤트(orderPlaced)로 부터 필요 정보만 get 하는 부분
            Delivery delivery = new Delivery();
            delivery.setOrderId(orderPlaced.getId());
            delivery.setProductId(orderPlaced.getProductId());
            delivery.setProductName(orderPlaced.getProductName());
            deliveryRepository.save(delivery);
        }
    }

}
