
package googledriveexample.service;

import java.util.List;
import googledriveexample.dto.entity.Dashboard;

public interface DashboardService{
    public List<Dashboard> getList();

    public Dashboard getById(Long id);

}