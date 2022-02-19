package googledriveexample.dto.entity;

import java.util.Date;
import lombok.Data;
@Data
public class File{
    private Long id;
    private Long size;
    private String name;
    private Long userId;
    private String uploader;

    
}