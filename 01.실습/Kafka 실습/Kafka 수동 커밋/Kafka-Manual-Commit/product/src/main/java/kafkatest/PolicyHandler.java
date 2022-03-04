package kafkatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import kafkatest.config.kafka.KafkaProcessor;

@Service
public class PolicyHandler{
    @Autowired ProductRepository productRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    /*
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderPlaced_PrintMessage(@Payload OrderPlaced orderPlaced){

        if(!orderPlaced.validate()) return;

        System.out.println("\n\n##### listener PrintMessage : " + orderPlaced.toJson() + "\n\n");

        // Sample Logic //
        // Product product = new Product();
        // productRepository.save(product);

    }
    */
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderPlaced_PrintMessage(@Payload OrderPlaced orderPlaced, 
                    @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment) {

        System.out.println("Entering listener: " + orderPlaced.getId());
        System.out.println("Entering listener: " + orderPlaced.getMessage());

        acknowledgment.acknowledge();

    } 


}


