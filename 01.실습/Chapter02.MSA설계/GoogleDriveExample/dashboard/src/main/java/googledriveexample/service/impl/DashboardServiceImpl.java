package googledriveexample.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import googledriveexample.dto.entity.Dashboard;
import googledriveexample.mapper.DashboardMapper;

@Service
public class DashboardServiceImpl implements DashboardService{
    @Autowired
    DashboardMapper dashboardMapper;
    
    @Override
    public List<Dashboard> getList(){
        List<Dashboard> dashboardList = dashboardMapper.findList();

        return dashboardList;
    }

    @Override
    public Dashboard getById(Long id){
        Dashboard dashboard = dashboardMapper.findOneById(id);

        return dashboard;
    }
}

