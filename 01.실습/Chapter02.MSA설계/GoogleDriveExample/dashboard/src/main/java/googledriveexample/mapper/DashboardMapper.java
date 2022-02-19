package googledriveexample.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import googledriveexample.dto.entity.Dashboard;

@Mapper
public interface DashboardMapper{
    public List<Dashboard> findList();

    public Dashboard findOneById(Long id);
} 