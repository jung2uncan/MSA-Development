
package googledriveexample.service;

import java.util.List;
import googledriveexample.dto.entity.Notification;

public interface NotificationService{
    public List<Notification> getList();

    public void save(Notification notification);

    public Notification getById(Long id);

    public void delete(Long id);

    public void update(Notification notification);
}