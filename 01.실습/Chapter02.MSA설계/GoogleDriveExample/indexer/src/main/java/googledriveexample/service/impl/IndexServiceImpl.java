
package googledriveexample.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import googledriveexample.dto.entity.Index;
import googledriveexample.mapper.IndexMapper;
import googledriveexample.service.IndexService;

@Transactional
@Service
public class IndexServiceImpl implements IndexService{
    @Autowired
    IndexMapper indexMapper;
    
    @Override
    public List<Index> getList(){
        List<Index> indexList = indexMapper.findList();

        return indexList;
    }

    @Override
    public void save(Index index){
        
        indexMapper.save(index); 

        
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // FileIndexed fileIndexed = new FileIndexed();
        // BeanUtils.copyProperties(index, fileIndexed);
        // fileIndexed.publish(fileIndexed.getId());

        
        
        
    }

    @Override
    public Index getById(Long id){
        Index index = indexMapper.findOneById(id);

        return index;
    }

    @Override
    public void delete(Long id){
        
        indexMapper.deleteById(id); 


    }

    @Override
    public void update(Index index){

        indexMapper.update(index); 



    }
}
