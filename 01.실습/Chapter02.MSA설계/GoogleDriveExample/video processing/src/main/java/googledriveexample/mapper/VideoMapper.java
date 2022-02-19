package googledriveexample.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import googledriveexample.dto.entity.Video;

@Mapper
public interface VideoMapper{
    public List<Video> findList();

    public Video findOneById(Long id);

    public void save(Video video);

    public void update(Video video);

    public void deleteById(Long id);
} 