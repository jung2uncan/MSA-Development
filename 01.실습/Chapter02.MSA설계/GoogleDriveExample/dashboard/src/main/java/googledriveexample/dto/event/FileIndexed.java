package googledriveexample.dto.event;

import java.util.Date;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FileIndexed extends AbstractEvent {

    private Long id;
    private Long fileId;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public Long getfileId() {
        return fileId;
    }

    public void setfileId(Long fileId) {
        this.fileId = fileId;
    }
}