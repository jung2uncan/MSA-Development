package shopping.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import shopping.dto.entity.Inventory;

@Mapper
public interface InventoryMapper{
    public List<Inventory> findList();

    public Inventory findOneById(Long id);

    public void save(Inventory inventory);

    public void update(Inventory inventory);

    public void deleteById(Long id);
} 