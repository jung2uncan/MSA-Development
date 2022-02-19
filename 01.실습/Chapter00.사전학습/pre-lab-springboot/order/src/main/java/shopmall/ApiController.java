package shopmall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/getProduct/{productId}")
    Object productStockCheck(@PathVariable(value = "productId") Long productId) {

        String productUrl = "http://localhost:8082" + "/products/" + productId;

        // 상품 서비스의 재고량 조회
        ResponseEntity<Map> productEntity = restTemplate.getForEntity(productUrl, Map.class);
        Map productMap = productEntity.getBody();

        return productMap;
    }

    //상품 추가 : http POST http://localhost:8081/saveProduct productName=="CUP" stock==10
    @PostMapping("/saveProduct")
    Object productInsert(@RequestParam String productName, @RequestParam int stock) {
        String productUrl = "http://localhost:8082" + "/products/";

        System.out.println("productName = " + productName);
        System.out.println("stock = " + stock);

        Map<String, Object> map = new HashMap<>();
        map.put("name", productName);
        map.put("stock", stock);
        ResponseEntity<Map> productEntity = restTemplate.postForEntity(productUrl, map, Map.class);

        Map productMap = productEntity.getBody();
        return productMap;
    }

    //호출 : http http://localhost:8081/getProductByName?productName=CUP
    @GetMapping("/getProductByName")
    Object productByName(@RequestParam String productName){
        //http http://localhost:8082/products/search/findByName\?name\=TV
        String productUrl = "http://localhost:8082/products/search/findByName?name=" + productName;
        
        System.out.println("productUrl : " + productUrl);
        ResponseEntity<Map> productEntity = restTemplate.getForEntity(productUrl, Map.class);
        Map productMap = productEntity.getBody();

        return productMap;
    }
}
