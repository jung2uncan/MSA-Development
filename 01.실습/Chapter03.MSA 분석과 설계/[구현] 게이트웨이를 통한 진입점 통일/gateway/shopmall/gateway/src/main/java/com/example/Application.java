package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Application.class, args);
    }


}

//주문 리스트 호출 :  http localhost:8080/orders
//주문 상품 추가 : http localhost:8080/orders productId=1 productName="PC" qty=1
//주문정보 수정 : http PATCH http://localhost:8080/orders/1 qty=100
//배달 정보 조회 : http localhost:8080/deliveries

