package googledriveexample;


public class VideoProcessed extends AbstractEvent {

    private Long id;
    private Long fileId;
    private String videoUrl;

    public VideoProcessed(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }
    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long FileId) {
        this.fileId = fileId;
    }
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String VideoUrl) {
        this.videoUrl = videoUrl;
    }
}
