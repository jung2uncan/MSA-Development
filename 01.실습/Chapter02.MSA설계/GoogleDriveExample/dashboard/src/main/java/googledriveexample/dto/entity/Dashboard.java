package googledriveexample.dto.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Dashboard{
        private Long id;
        private Long fileSize;
        private String fileName;
        private Boolean uploaded;
        private Boolean indexed;
        private String videoUrl;
        private Long userId;
        private String uploader;

}