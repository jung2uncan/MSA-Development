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
    @Autowired IndexRepository indexRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverFileUploaded_MakeIndex(@Payload FileUploaded fileUploaded){

        if(!fileUploaded.validate()) return;

        System.out.println("\n\n##### listener MakeIndex : " + fileUploaded.toJson() + "\n\n");


        

        // Sample Logic //
        // Index index = new Index();
        // indexRepository.save(index);

    }


}


