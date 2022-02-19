
package googledriveexample.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import googledriveexample.service.NotificationService;
import googledriveexample.dto.entity.Notification;

@RestController
@RequestMapping(value="/notifications")
public class NotificationController{

    @Autowired
    NotificationService notificationService;


    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<?> getList() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", notificationService.getList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Notification getById(@PathVariable(value="id") Long id){
        Notification notification = notificationService.getById(id);

        return notification;
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public Notification post(@RequestBody Notification notification){
        notificationService.save(notification);
        
        return notification;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public void put(@PathVariable(value="id") Long id, @RequestBody Notification notification){
        notification.setId(id);
        notificationService.update(notification);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletebyId(@PathVariable(value="id") Long id){
        notificationService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}