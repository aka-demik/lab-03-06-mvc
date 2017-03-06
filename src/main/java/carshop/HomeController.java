package carshop;

import carshop.models.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showBasePage() {
        return "home";
    }

    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public String showTextPage(Model model) {
        model.addAttribute("myText", "My super text");
        return "text";
    }

    @RequestMapping(value = "/text", method = RequestMethod.POST)
    public String showPostMessage(Model model,
                  @RequestParam(name = "param1", defaultValue = "1") String param) {

        model.addAttribute("myText", param);
        return "text";
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public ModelAndView showModelPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("text");
        modelAndView.addObject("car", new Car(10000, "carr", "E777KX"));

        return modelAndView;
    }

    @RequestMapping(value = "/model/showfullcar", method = RequestMethod.POST)
    public ModelAndView showFullCarr(@ModelAttribute("car") Car car) {
        ModelAndView modelAndView = new ModelAndView("fullCarr");
        modelAndView.addObject("car", car);

        return modelAndView;
    }
}
