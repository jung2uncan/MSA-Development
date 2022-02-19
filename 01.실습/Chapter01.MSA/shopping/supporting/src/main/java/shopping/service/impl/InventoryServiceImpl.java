
package shopping.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping.dto.entity.Inventory;
import shopping.mapper.InventoryMapper;
import shopping.service.InventoryService;

@Transactional
@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    InventoryMapper inventoryMapper;
    
    @Override
    public List<Inventory> getList(){
        List<Inventory> inventoryList = inventoryMapper.findList();

        return inventoryList;
    }

    @Override
    public void save(Inventory inventory){
        
        inventoryMapper.save(inventory); 

        
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // InventoryDecreased inventoryDecreased = new InventoryDecreased();
        // BeanUtils.copyProperties(inventory, inventoryDecreased);
        // inventoryDecreased.publish(inventoryDecreased.getId());

        
        
        
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // InventoryIncresed inventoryIncresed = new InventoryIncresed();
        // BeanUtils.copyProperties(inventory, inventoryIncresed);
        // inventoryIncresed.publish(inventoryIncresed.getId());

        
        
        
    }

    @Override
    public Inventory getById(Long id){
        Inventory inventory = inventoryMapper.findOneById(id);

        return inventory;
    }

    @Override
    public void delete(Long id){
        
        inventoryMapper.deleteById(id); 


    }

    @Override
    public void update(Inventory inventory){

        inventoryMapper.update(inventory); 



    }
}
