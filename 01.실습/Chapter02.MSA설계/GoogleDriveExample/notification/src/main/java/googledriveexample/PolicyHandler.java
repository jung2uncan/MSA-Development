package googledriveexample;

import googledriveexample.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverFileUploaded_NotifyToUser(@Payload FileUploaded fileUploaded){

        if(!fileUploaded.validate()) return;

        System.out.println("\n\n##### listener NotifyToUser : " + fileUploaded.toJson() + "\n\n");

        // REST Request Sample
        // googledriveexample.external.File file =
        //    NotificationApplication.applicationContext.getBean(googledriveexample.external.FileService.class)
        //    .getFile(/** mapping value needed */);


        

        // Sample Logic //
        // Notification notification = new Notification();
        // notificationRepository.save(notification);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverVideoProcessed_NotifyToUser(@Payload VideoProcessed videoProcessed){

        if(!videoProcessed.validate()) return;

        System.out.println("\n\n##### listener NotifyToUser : " + videoProcessed.toJson() + "\n\n");

        // REST Request Sample
        // googledriveexample.external.File file =
        //    NotificationApplication.applicationContext.getBean(googledriveexample.external.FileService.class)
        //    .getFile(/** mapping value needed */);


        

        // Sample Logic //
        // Notification notification = new Notification();
        // notificationRepository.save(notification);

    }


}


