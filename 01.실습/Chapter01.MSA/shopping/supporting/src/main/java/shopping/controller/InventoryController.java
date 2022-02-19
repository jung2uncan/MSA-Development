
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

import shopping.service.InventoryService;
import shopping.dto.entity.Inventory;

@RestController
@RequestMapping(value="/inventories")
public class InventoryController{

    @Autowired
    InventoryService inventoryService;


    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<?> getList() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", inventoryService.getList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Inventory getById(@PathVariable(value="id") Long id){
        Inventory inventory = inventoryService.getById(id);

        return inventory;
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public Inventory post(@RequestBody Inventory inventory){
        inventoryService.save(inventory);
        
        return inventory;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public void put(@PathVariable(value="id") Long id, @RequestBody Inventory inventory){
        inventory.setId(id);
        inventoryService.update(inventory);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletebyId(@PathVariable(value="id") Long id){
        inventoryService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}