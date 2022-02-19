
package googledriveexample.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import googledriveexample.dto.entity.File;
import googledriveexample.mapper.FileMapper;
import googledriveexample.service.FileService;

@Transactional
@Service
public class FileServiceImpl implements FileService{
    @Autowired
    FileMapper fileMapper;
    
    @Override
    public List<File> getList(){
        List<File> fileList = fileMapper.findList();

        return fileList;
    }

    @Override
    public void save(File file){
        
        fileMapper.save(file); 

        
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // FileUploaded fileUploaded = new FileUploaded();
        // BeanUtils.copyProperties(file, fileUploaded);
        // fileUploaded.publish(fileUploaded.getId());

        
        
        
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // FileDeleted fileDeleted = new FileDeleted();
        // BeanUtils.copyProperties(file, fileDeleted);
        // fileDeleted.publish(fileDeleted.getId());

        
        
        
    }

    @Override
    public File getById(Long id){
        File file = fileMapper.findOneById(id);

        return file;
    }

    @Override
    public void delete(Long id){
        
        fileMapper.deleteById(id); 


    }

    @Override
    public void update(File file){

        fileMapper.update(file); 



    }
}
