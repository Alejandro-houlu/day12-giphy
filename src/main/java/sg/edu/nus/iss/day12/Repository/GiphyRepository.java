package sg.edu.nus.iss.day12.Repository;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import org.springframework.stereotype.Repository;

@Repository
public class GiphyRepository {

    public List<String> getImages(String resp){
        String images = "$.data.*.images.fixed_width.url";
        DocumentContext jsonContext = JsonPath.parse(resp);
        List<String> urls = jsonContext.read(images);

        return urls;
         
    }
    
}
