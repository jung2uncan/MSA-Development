
package googledriveexample.service;

import java.util.List;
import googledriveexample.dto.entity.File;

public interface FileService{
    public List<File> getList();

    public void save(File file);

    public File getById(Long id);

    public void delete(Long id);

    public void update(File file);
}