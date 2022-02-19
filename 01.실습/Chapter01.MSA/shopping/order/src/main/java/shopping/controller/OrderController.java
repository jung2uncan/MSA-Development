
package shopping.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shopping.service.OrderService;
import shopping.dto.entity.Order;

@RestController
@RequestMapping(value="/orders")
public class OrderController{

    @Autowired
    OrderService orderService;


@RequestMapping(value = "/",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8")

public void order(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        System.out.println("##### /order/order  called #####");
        }

@RequestMapping(value = "/",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8")

public void cancel(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        System.out.println("##### /order/cancel  called #####");
        }

    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<?> getList() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", orderService.getList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Order getById(@PathVariable(value="id") Long id){
        Order order = orderService.getById(id);

        return order;
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public Order post(@RequestBody Order order){
        orderService.save(order);
        
        return order;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public void put(@PathVariable(value="id") Long id, @RequestBody Order order){
        order.setId(id);
        orderService.update(order);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletebyId(@PathVariable(value="id") Long id){
        orderService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}