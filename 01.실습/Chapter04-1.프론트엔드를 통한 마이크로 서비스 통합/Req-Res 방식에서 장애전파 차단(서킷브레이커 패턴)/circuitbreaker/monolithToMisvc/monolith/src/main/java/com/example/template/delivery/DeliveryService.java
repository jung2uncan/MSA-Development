package com.example.template.delivery;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name ="delivery", url="${api.url.delivery}")

//서비스로의 요청 실패가 임계치를 넘으면 대신 fallback 클래스로 설정된 파일이 실행
@FeignClient(name ="delivery", url="${api.url.delivery}", fallback = DeliveryServiceImpl.class)
public interface DeliveryService {

    @RequestMapping(method = RequestMethod.POST, value = "/deliveries", consumes = "application/json")
    void startDelivery(Delivery delivery);

}
