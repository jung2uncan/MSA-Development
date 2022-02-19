package googledriveexample.dto.entity;

import java.util.Date;
import lombok.Data;
@Data
public class Notification{
    private Long id;
    private String fileName;
    private Long fileId;
    private Long userId;
    private String uploader;

    
}