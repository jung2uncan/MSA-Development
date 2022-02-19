package googledriveexample;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Dashboard_table")
public class Dashboard {

        private Long id;
        private Long fileSize;
        private String fileName;
        private Boolean uploaded;
        private Boolean indexed;
        private String videoUrl;
        private Long userId;
        private String uploader;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getFileSize() {
            return fileSize;
        }

        public void setFileSize(Long fileSize) {
            this.fileSize = fileSize;
        }
        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
        public Boolean getUploaded() {
            return uploaded;
        }

        public void setUploaded(Boolean uploaded) {
            this.uploaded = uploaded;
        }
        public Boolean getIndexed() {
            return indexed;
        }

        public void setIndexed(Boolean indexed) {
            this.indexed = indexed;
        }
        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
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