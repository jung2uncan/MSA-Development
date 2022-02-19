package googledriveexample.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import googledriveexample.dto.entity.Notification;

@Mapper
public interface NotificationMapper{
    public List<Notification> findList();

    public Notification findOneById(Long id);

    public void save(Notification notification);

    public void update(Notification notification);

    public void deleteById(Long id);
} 