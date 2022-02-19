package googledriveexample.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardViewHandler {


    @Autowired
    private DashboardService dashboardService;

    @Override
    @KafkaListener(topics = "", groupId = "", containerFactory = "kafkaListenerContainerFactory")
    public void whenFileUploaded_then_CREATE_1 (ConsumerRecord data, Acknowledgment acknowledgment) {
        try {

            if (!fileUploaded.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setid(fileUploaded.getid());
            dashboard.setfileSize(fileUploaded.getsize());
            dashboard.setfileName(fileUploaded.getname());
            dashboard.setuploaded(true);
            // view 레파지 토리에 save
            dashboardService.save(dashboard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileIndexed_then_UPDATE_1(@Payload FileIndexed fileIndexed) {
        try {
            if (!fileIndexed.validate()) return;
                // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findByid(fileIndexed.getfileId());

            if( dashboardOptional.isPresent()) {
                 Dashboard dashboard = dashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 dashboard.setindexed(true);
                // view 레파지 토리에 save
                 dashboardservice.save(dashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileDeleted_then_UPDATE_2(@Payload FileDeleted fileDeleted) {
        try {
            if (!fileDeleted.validate()) return;
                // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findByid(fileDeleted.getid());

            if( dashboardOptional.isPresent()) {
                 Dashboard dashboard = dashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 dashboard.setuploaded(false);
                // view 레파지 토리에 save
                 dashboardservice.save(dashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileDeleted_then_UPDATE_3(@Payload FileDeleted fileDeleted) {
        try {
            if (!fileDeleted.validate()) return;
                // view 객체 조회

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileDeleted_then_DELETE_1(@Payload FileDeleted fileDeleted) {
        try {
            if (!fileDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            dashboardRepository.deleteById(fileDeleted.getid());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

