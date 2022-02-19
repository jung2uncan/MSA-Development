package googledriveexample.dto.event;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FileIndexed extends AbstractEvent {

    private Long id;
    private Long fileId;

    public FileIndexed(){
        super();
    }
}