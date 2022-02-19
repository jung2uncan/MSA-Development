
package shopping.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping.dto.entity.Order;
import shopping.mapper.OrderMapper;
import shopping.service.OrderService;

@Transactional
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;
    
    @Override
    public List<Order> getList(){
        List<Order> orderList = orderMapper.findList();

        return orderList;
    }

    @Override
    public void save(Order order){
        
        orderMapper.save(order); 

        
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // OrderPlaced orderPlaced = new OrderPlaced();
        // BeanUtils.copyProperties(order, orderPlaced);
        // orderPlaced.publish(orderPlaced.getId());

        
        
        
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // OrderCancled orderCancled = new OrderCancled();
        // BeanUtils.copyProperties(order, orderCancled);
        // orderCancled.publish(orderCancled.getId());

        
        
        
    }

    @Override
    public Order getById(Long id){
        Order order = orderMapper.findOneById(id);

        return order;
    }

    @Override
    public void delete(Long id){
        
        orderMapper.deleteById(id); 


    }

    @Override
    public void update(Order order){

        orderMapper.update(order); 



    }
}
