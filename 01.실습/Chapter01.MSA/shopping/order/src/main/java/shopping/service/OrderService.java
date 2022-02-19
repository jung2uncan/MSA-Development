
package shopping.service;

import java.util.List;
import shopping.dto.entity.Order;

public interface OrderService{
    public List<Order> getList();

    public void save(Order order);

    public Order getById(Long id);

    public void delete(Long id);

    public void update(Order order);
}