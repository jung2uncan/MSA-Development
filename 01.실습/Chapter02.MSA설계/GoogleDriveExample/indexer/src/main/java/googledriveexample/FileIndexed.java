package googledriveexample;


public class FileIndexed extends AbstractEvent {

    private Long id;
    private Long fileId;

    public FileIndexed(){
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
}
