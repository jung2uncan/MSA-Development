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
    @Autowired VideoRepository videoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverFileIndexed_ProcessVideo(@Payload FileIndexed fileIndexed){

        if(!fileIndexed.validate()) return;

        System.out.println("\n\n##### listener ProcessVideo : " + fileIndexed.toJson() + "\n\n");


        // Comments // 
		//(after checking the file type)
		// 비디오 파일인지 아닌지 판별한 후, 비디오 파일이면 스트리밍 처리한다.
		// 
		// (Data를 보내주는 Pub 입장에서는 별도 처리는 하지 않는다.)

        // Sample Logic //
        // Video video = new Video();
        // videoRepository.save(video);

    }


}


