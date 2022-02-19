
package shopping.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping.dto.entity.Delivery;
import shopping.mapper.DeliveryMapper;
import shopping.service.DeliveryService;

@Transactional
@Service
public class DeliveryServiceImpl implements DeliveryService{
    @Autowired
    DeliveryMapper deliveryMapper;
    
    @Override
    public List<Delivery> getList(){
        List<Delivery> deliveryList = deliveryMapper.findList();

        return deliveryList;
    }

    @Override
    public void save(Delivery delivery){
        
        deliveryMapper.save(delivery); 

        
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // DeliveryStarted deliveryStarted = new DeliveryStarted();
        // BeanUtils.copyProperties(delivery, deliveryStarted);
        // deliveryStarted.publish(deliveryStarted.getId());

        
        
        
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // DeliveryReturned deliveryReturned = new DeliveryReturned();
        // BeanUtils.copyProperties(delivery, deliveryReturned);
        // deliveryReturned.publish(deliveryReturned.getId());

        
        
        
    }

    @Override
    public Delivery getById(Long id){
        Delivery delivery = deliveryMapper.findOneById(id);

        return delivery;
    }

    @Override
    public void delete(Long id){
        
        deliveryMapper.deleteById(id); 


    }

    @Override
    public void update(Delivery delivery){

        deliveryMapper.update(delivery); 



    }
}
