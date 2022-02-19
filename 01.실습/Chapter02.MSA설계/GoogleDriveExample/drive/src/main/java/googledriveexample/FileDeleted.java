package googledriveexample;


public class FileDeleted extends AbstractEvent {

    private Long id;
    private Long size;
    private String name;
    private String uploader;

    public FileDeleted(){
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
    public String getUploader() {
        return uploader;
    }

    public void setUploader(String Uploader) {
        this.uploader = uploader;
    }
}
