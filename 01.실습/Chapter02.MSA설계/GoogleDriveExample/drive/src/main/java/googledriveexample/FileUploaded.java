package googledriveexample;


public class FileUploaded extends AbstractEvent {

    private Long id;
    private Long size;
    private String name;
    private Long userId;
    private String uploader;

    public FileUploaded(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }
    public Long getSize() {
        return size;
    }

    public void setSize(Long Size) {
        this.size = size;
    }
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long UserId) {
        this.userId = userId;
    }
    public String getUploader() {
        return uploader;
    }

    public void setUploader(String Uploader) {
        this.uploader = uploader;
    }
}
