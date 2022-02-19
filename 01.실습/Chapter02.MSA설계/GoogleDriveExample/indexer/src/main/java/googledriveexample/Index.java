package googledriveexample;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="Index_table")
public class Index  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Long id;
    
    private Long fileId;

    @PostPersist
    public void onPostPersist(){
        FileIndexed fileIndexed = new FileIndexed();
        BeanUtils.copyProperties(this, fileIndexed);
        fileIndexed.publishAfterCommit();

    }

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
    



}
