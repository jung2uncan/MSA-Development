
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

import shopping.service.DeliveryService;
import shopping.dto.entity.Delivery;

@RestController
@RequestMapping(value="/deliveries")
public class DeliveryController{

    @Autowired
    DeliveryService deliveryService;


    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<?> getList() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", deliveryService.getList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Delivery getById(@PathVariable(value="id") Long id){
        Delivery delivery = deliveryService.getById(id);

        return delivery;
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public Delivery post(@RequestBody Delivery delivery){
        deliveryService.save(delivery);
        
        return delivery;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public void put(@PathVariable(value="id") Long id, @RequestBody Delivery delivery){
        delivery.setId(id);
        deliveryService.update(delivery);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletebyId(@PathVariable(value="id") Long id){
        deliveryService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}