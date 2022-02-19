package googledriveexample.listener;

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
import googledriveexample.service.NotificationService;

import googledriveexample.dto.event.FileUploaded;
import googledriveexample.dto.event.VideoProcessed;

@Service
@KafkaListener(topics = "googledriveexample", groupId = "notification", containerFactory = "kafkaListenerContainerFactory",contentTypeConverter="smartMessageConverter")
public class PolicyHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyHandler.class);

    @Autowired NotificationService notificationService;

    @KafkaHandler
    public void wheneverFileUploaded_NotifyToUser(@Payload FileUploaded fileUploaded, Acknowledgment acknowledgment,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey){

        
            
        // REST Request Sample
        // googledriveexample.external.File file =
        //    NotificationApplication.applicationContext.getBean(googledriveexample.external.FileService.class)
        //    .getFile(/** mapping value needed */);



        // Sample Logic //
        // Notification notification = new Notification();
        // notificationService.save(notification);
        
        acknowledgment.acknowledge();
        

    }
    @KafkaHandler
    public void wheneverVideoProcessed_NotifyToUser(@Payload VideoProcessed videoProcessed, Acknowledgment acknowledgment,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey){

        
            
        // REST Request Sample
        // googledriveexample.external.File file =
        //    NotificationApplication.applicationContext.getBean(googledriveexample.external.FileService.class)
        //    .getFile(/** mapping value needed */);



        // Sample Logic //
        // Notification notification = new Notification();
        // notificationService.save(notification);
        
        acknowledgment.acknowledge();
        

    }

    @KafkaHandler(isDefault = true)
    public void listenDefault(Object object, Acknowledgment acknowledgment) {
        System.out.println("[Info] Unhandled Event from Kafka broker: " + object.toString());
        acknowledgment.acknowledge();
    }

    


}