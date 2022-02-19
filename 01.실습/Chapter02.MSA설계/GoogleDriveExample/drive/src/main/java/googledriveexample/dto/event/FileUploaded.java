package googledriveexample.dto.event;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FileUploaded extends AbstractEvent {

    private Long id;
    private Long size;
    private String name;
    private Long userId;
    private String uploader;

    public FileUploaded(){
        super();
    }
}