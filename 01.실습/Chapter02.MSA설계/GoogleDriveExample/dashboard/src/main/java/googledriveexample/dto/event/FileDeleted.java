package googledriveexample.dto.event;

import java.util.Date;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FileDeleted extends AbstractEvent {

    private Long id;
    private Long size;
    private String name;
    private String uploader;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public Long getsize() {
        return size;
    }

    public void setsize(Long size) {
        this.size = size;
    }
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
    public String getuploader() {
        return uploader;
    }

    public void setuploader(String uploader) {
        this.uploader = uploader;
    }
}