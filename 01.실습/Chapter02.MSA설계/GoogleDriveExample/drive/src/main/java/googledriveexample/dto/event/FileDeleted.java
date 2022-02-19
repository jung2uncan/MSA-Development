package googledriveexample.dto.event;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FileDeleted extends AbstractEvent {

    private Long id;
    private Long size;
    private String name;
    private String uploader;

    public FileDeleted(){
        super();
    }
}