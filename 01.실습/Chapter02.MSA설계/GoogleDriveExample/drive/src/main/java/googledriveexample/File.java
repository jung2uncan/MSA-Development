package googledriveexample;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="File_table")
public class File  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Long id;
    
    private Long size;
    
    private String name;
    
    private Long userId;
    
    private String uploader;

    @PostPersist
    public void onPostPersist(){
        FileUploaded fileUploaded = new FileUploaded();
        BeanUtils.copyProperties(this, fileUploaded);
        fileUploaded.publishAfterCommit();

        FileDeleted fileDeleted = new FileDeleted();
        BeanUtils.copyProperties(this, fileDeleted);
        fileDeleted.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
    



}
