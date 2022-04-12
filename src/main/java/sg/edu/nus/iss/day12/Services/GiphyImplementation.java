package sg.edu.nus.iss.day12.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import sg.edu.nus.iss.day12.Repository.GiphyRepository;
@Service
public class GiphyImplementation implements GiphyInterface {

    private String apiUrl = "https://api.giphy.com/v1/gifs";
    
    @Value("${OPEN_GIPHY_MAP}")
    String apiKey;

    @Autowired
    GiphyRepository gRepo;

    @Override
    public List<String> getSearchResult(String phrase, Integer limit, String rating) {

        String url = createSearchUrl(phrase,limit,rating);
        String resp = accessApi(url);
        List<String> urls = gRepo.getImages(resp);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>URL" + url );
        urls.stream().forEach(x->System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Image Url " + x));

        //hello

        
        return urls;
    }

    @Override
    public String createSearchUrl(String phrase, Integer limit, String rating) {

        String url = UriComponentsBuilder.fromUriString(apiUrl)
                        .path("/search")
                        .queryParam("api_key", apiKey)
                        .queryParam("q", phrase)
                        .queryParam("limit", limit)
                        .queryParam("offset", 0)
                        .queryParam("rating", rating)
                        .queryParam("lang", "en")
                        .toUriString();

        return url;
    }

    @Override
    public String accessApi(String url) {

        RequestEntity<Void> req = RequestEntity.get(url).build();
        RestTemplate rTemplate = new RestTemplate();
        ResponseEntity<String> resp = rTemplate.exchange(req, String.class);    
        
        return resp.getBody();
    }

    @Override
    public List<String> getSearchResult(String phrase) {
        
        return getSearchResult(phrase, 10, "pg");
    }

    @Override
    public List<String> getSearchResult(String phrase, Integer limit) {
        
        return getSearchResult(phrase,limit,"pg") ;
    }
    
}
