package shopping.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import shopping.dto.entity.Order;

@Mapper
public interface OrderMapper{
    public List<Order> findList();

    public Order findOneById(Long id);

    public void save(Order order);

    public void update(Order order);

    public void deleteById(Long id);
} 