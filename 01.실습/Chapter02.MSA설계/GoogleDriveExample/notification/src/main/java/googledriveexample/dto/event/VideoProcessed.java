package googledriveexample.dto.event;

import java.util.Date;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class VideoProcessed extends AbstractEvent {

    private Long id;
    private Long fileId;
    private String videoURL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
    public String getVideoUrl() {
        return videoURL;
    }

    public void setVideoUrl(String videoURL) {
        this.videoURL = videoURL;
    }
}