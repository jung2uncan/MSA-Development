package googledriveexample.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="drive", url="http://drive:8080")
public interface FileService {
    @RequestMapping(method= RequestMethod.GET, path="/files/{id}")
    public File getFile(@PathVariable("id") Long id);

}

