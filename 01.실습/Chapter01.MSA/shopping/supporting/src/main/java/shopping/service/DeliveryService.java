
package shopping.service;

import java.util.List;
import shopping.dto.entity.Delivery;

public interface DeliveryService{
    public List<Delivery> getList();

    public void save(Delivery delivery);

    public Delivery getById(Long id);

    public void delete(Long id);

    public void update(Delivery delivery);
}