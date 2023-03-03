package ssf.workshop11.controller;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/test")
public class IndexResourceController {

    private List<Integer> l = new LinkedList<>();

    @GetMapping(path={"/index.html", "/trixie"}, produces = {"text/html"})
    public String indexPage(Model model){
        Calendar cal = Calendar.getInstance();
        l.clear();
        for(int x=0; x < 5; x++){
            l.add(x+1);
        }
        model.addAttribute("trixie", 40+6);
        model.addAttribute("name", "Trixie");
        model.addAttribute("currHour", cal.get(Calendar.HOUR_OF_DAY));
        model.addAttribute("listOfNum", l);
        return "index";
    }

    @GetMapping(path="/weather/{city}")
    public String showCity(@PathVariable String city, @RequestParam(required = true) String name, Model m){
        m.addAttribute("city", city);
        m.addAttribute("name", name + "Lim");
        return "city";
    }
}
