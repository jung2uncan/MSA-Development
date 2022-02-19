
package googledriveexample.service;

import java.util.List;
import googledriveexample.dto.entity.Index;

public interface IndexService{
    public List<Index> getList();

    public void save(Index index);

    public Index getById(Long id);

    public void delete(Long id);

    public void update(Index index);
}