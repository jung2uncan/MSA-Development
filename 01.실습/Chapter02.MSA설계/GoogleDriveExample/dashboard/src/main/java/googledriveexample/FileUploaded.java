package googledriveexample;


public class FileUploaded extends AbstractEvent {

    private Long id;
    private Long size;
    private String name;
    private Long userID;
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
    public Long getuserID() {
        return userID;
    }

    public void setuserID(Long userID) {
        this.userID = userID;
    }
    public String getuploader() {
        return uploader;
    }

    public void setuploader(String uploader) {
        this.uploader = uploader;
    }
}
