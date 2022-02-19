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
import shopping.service.DeliveryService;
import shopping.service.InventoryService;

import shopping.dto.event.OrderPlaced;
import shopping.dto.event.DeliveryStarted;
import shopping.dto.event.OrderCancled;
import shopping.dto.event.DeliveryReturned;

@Service
@KafkaListener(topics = "shopping", groupId = "boundedContext57_499961853027344", containerFactory = "kafkaListenerContainerFactory",contentTypeConverter="smartMessageConverter")
public class PolicyHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyHandler.class);

    @Autowired DeliveryService deliveryService;
    @Autowired InventoryService inventoryService;

    @KafkaHandler
    public void wheneverOrderPlaced_StartDelivery(@Payload OrderPlaced orderPlaced, Acknowledgment acknowledgment,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey){

        
            


        // Sample Logic //
        // Delivery delivery = new Delivery();
        // deliveryService.save(delivery);
        // Inventory inventory = new Inventory();
        // inventoryService.save(inventory);
        
        acknowledgment.acknowledge();
        

    }
    @KafkaHandler
    public void wheneverDeliveryStarted_DecreaseInventory(@Payload DeliveryStarted deliveryStarted, Acknowledgment acknowledgment,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey){

        
            


        // Sample Logic //
        // Delivery delivery = new Delivery();
        // deliveryService.save(delivery);
        // Inventory inventory = new Inventory();
        // inventoryService.save(inventory);
        
        acknowledgment.acknowledge();
        

    }
    @KafkaHandler
    public void wheneverOrderCancled_CancleDelivery(@Payload OrderCancled orderCancled, Acknowledgment acknowledgment,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey){

        
            


        // Sample Logic //
        // Delivery delivery = new Delivery();
        // deliveryService.save(delivery);
        // Inventory inventory = new Inventory();
        // inventoryService.save(inventory);
        
        acknowledgment.acknowledge();
        

    }
    @KafkaHandler
    public void wheneverDeliveryReturned_IncreseInventory(@Payload DeliveryReturned deliveryReturned, Acknowledgment acknowledgment,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey){

        
            


        // Sample Logic //
        // Delivery delivery = new Delivery();
        // deliveryService.save(delivery);
        // Inventory inventory = new Inventory();
        // inventoryService.save(inventory);
        
        acknowledgment.acknowledge();
        

    }

    @KafkaHandler(isDefault = true)
    public void listenDefault(Object object, Acknowledgment acknowledgment) {
        System.out.println("[Info] Unhandled Event from Kafka broker: " + object.toString());
        acknowledgment.acknowledge();
    }

    


}