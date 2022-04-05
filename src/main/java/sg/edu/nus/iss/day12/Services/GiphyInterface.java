package sg.edu.nus.iss.day12.Services;

import java.util.List;

public interface GiphyInterface {

    public List<String> getSearchResult(String phrase, Integer limit, String rating);
    public List<String> getSearchResult(String phrase);
    public List<String> getSearchResult(String phrase, Integer limit);

    public String createSearchUrl(String phrase, Integer limit, String rating);

    public String accessApi(String url);
    
}
