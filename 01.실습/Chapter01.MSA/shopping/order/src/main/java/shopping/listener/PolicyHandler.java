package shopping.listener;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaHandler;
import shopping.service.OrderService;

import shopping.dto.event.InventoryIncresed;
import shopping.dto.event.DeliveryReturned;
import shopping.dto.event.DeliveryStarted;

@Service
@KafkaListener(topics = "shopping", groupId = "boundedContext115", containerFactory = "kafkaListenerContainerFactory",contentTypeConverter="smartMessageConverter")
public class PolicyHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyHandler.class);

    @Autowired OrderService orderService;

    @KafkaHandler
    public void wheneverInventoryIncresed_SendMail(@Payload InventoryIncresed inventoryIncresed, Acknowledgment acknowledgment,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey){

        
            


        // Sample Logic //
        // Order order = new Order();
        // orderService.save(order);
        
        acknowledgment.acknowledge();
        

    }
    @KafkaHandler
    public void wheneverDeliveryReturned_UpdateDeliveryStatus(@Payload DeliveryReturned deliveryReturned, Acknowledgment acknowledgment,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey){

        
            


        // Sample Logic //
        // Order order = new Order();
        // orderService.save(order);
        
        acknowledgment.acknowledge();
        

    }
    @KafkaHandler
    public void wheneverDeliveryStarted_UpdateDeliveryStatus(@Payload DeliveryStarted deliveryStarted, Acknowledgment acknowledgment,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey){

        
            


        // Sample Logic //
        // Order order = new Order();
        // orderService.save(order);
        
        acknowledgment.acknowledge();
        

    }

    @KafkaHandler(isDefault = true)
    public void listenDefault(Object object, Acknowledgment acknowledgment) {
        System.out.println("[Info] Unhandled Event from Kafka broker: " + object.toString());
        acknowledgment.acknowledge();
    }

    


}