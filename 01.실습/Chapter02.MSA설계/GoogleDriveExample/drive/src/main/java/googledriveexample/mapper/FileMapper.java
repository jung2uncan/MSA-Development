package googledriveexample.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import googledriveexample.dto.entity.File;

@Mapper
public interface FileMapper{
    public List<File> findList();

    public File findOneById(Long id);

    public void save(File file);

    public void update(File file);

    public void deleteById(Long id);
} 