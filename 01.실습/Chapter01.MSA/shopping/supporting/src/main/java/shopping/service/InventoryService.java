
package shopping.service;

import java.util.List;
import shopping.dto.entity.Inventory;

public interface InventoryService{
    public List<Inventory> getList();

    public void save(Inventory inventory);

    public Inventory getById(Long id);

    public void delete(Long id);

    public void update(Inventory inventory);
}