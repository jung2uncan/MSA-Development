package shopping.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import shopping.dto.entity.Delivery;

@Mapper
public interface DeliveryMapper{
    public List<Delivery> findList();

    public Delivery findOneById(Long id);

    public void save(Delivery delivery);

    public void update(Delivery delivery);

    public void deleteById(Long id);
} 