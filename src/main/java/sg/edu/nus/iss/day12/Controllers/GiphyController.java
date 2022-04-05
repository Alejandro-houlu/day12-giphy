package sg.edu.nus.iss.day12.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.day12.Services.GiphyInterface;

@Controller
@RequestMapping(path="/")

public class GiphyController {

    @Autowired
    GiphyInterface gService;

    @RequestMapping("/")
    public String setForm(Model model){

        List<Integer> limitList = new ArrayList<>();
        List<String> ratingList = new ArrayList<>();

        for(int i = 1; i <= 20; i++){
            if(i % 5 == 0){
                limitList.add(i);
            }
        }
        ratingList.add("g");ratingList.add("pg");ratingList.add("pg-13");ratingList.add("r");

        model.addAttribute("limitList", limitList);
        model.addAttribute("ratingList", ratingList);

        return "index";
    }

    @GetMapping("/search")
    public String getGifs(@RequestParam String phrase, @RequestParam Integer limit, @RequestParam String rating, Model model){

        List<String> imageUrls = gService.getSearchResult(phrase, limit, rating);

        model.addAttribute("imageUrls", imageUrls);


        return "searchResult";
    }
    
}
