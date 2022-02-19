package shopmall;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    List<Order> orderList;

    public OrderController(){
        orderList = new ArrayList<Order>();
        Order order = new Order();
        order.setOrderId(1L);
        order.setProductId(1L);
        order.setProductName("MASK");
        order.setQty(3);
        orderList.add(order);
    }

    @GetMapping("/order")
    List<Order> allOrder() {
        return this.orderList;
    }

    

    @GetMapping("/order/{orderId}")
    List<Order> orderListByOrderId(@PathVariable(value = "orderId") Long orderId) {
        // use java8 stream
        return this.orderList
                .stream()
                .filter(order-> order.getOrderId().equals(orderId))
                .collect(Collectors.toList());

        // use for loop
//        for( Order order : this.orderList){
//            if( order.getOrderId().equals(orderId) ){
//                List<Order> listOrder = new ArrayList<>();
//                listOrder.add(order);
//                return listOrder;
//            }
//        }
//        return null;
    }

    @PostMapping("/order")
    List<Order> orderInsert(@RequestBody Order order) {
        this.orderList.add(order);
        return this.orderList;
    }

    @PutMapping("/order/{orderId}")
    List<Order> orderUpdate(@PathVariable(value = "orderId") Long orderId, @RequestBody Order orderData) {
        // use java8 stream
        return this.orderList = this.orderList
                .stream()
                .map((order)-> {
                    if( order.getOrderId().equals(orderId)){
                        order = orderData;
                        order.setOrderId(orderId);
                        return order;
                    }
                    return order;
                })
                .collect(Collectors.toList());

        // use for loop
//        int index = 0;
//        for( Order order : this.orderList){
//            if( order.getOrderId().equals(orderId) ){
//                orderData.setOrderId(orderId);
//                this.orderList.set(index, orderData);
//            }
//            index++;
//        }
//        return this.orderList;
    }

}
