package com.example.VlogApplication.Controller;

import com.example.VlogApplication.Model.Vlog;
import com.example.VlogApplication.Service.VlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private VlogService vlogService;

//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }

    @GetMapping("/")
    public String getVlogs(Model model) {
        List<Vlog> vlogs = vlogService.getAllVlogs(); // from DB or list
        model.addAttribute("vlogs", vlogs);
        return "home";
    }
    @GetMapping("add-vlog")
    public String addVLog(){
        return "addVlogPage";
    }

    @PostMapping("add-vlog")
    public String saveVlog(Vlog vLog){
        vlogService.createVlog(vLog);
        return "redirect:/";
    }
    @PostMapping("/delete/{id}")
    public String deleteVlog(@PathVariable Integer id) {
        vlogService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editVlog(@PathVariable Integer id, Model model) {
        Optional<Vlog> v = vlogService.findById(id);
        if (v.isPresent()) {
            model.addAttribute("x", v.get());
        }
        return "updateVlog";

    }
    @PostMapping("edit-vlog")
    public String updateVlog(Vlog vLog){
        System.out.println(vLog);
        vlogService.createVlog(vLog);
        return "redirect:/";
    }
    @GetMapping("delete-all-vlogs")
    public String deleteAllVlogs(){
        vlogService.deleteAllVlogs();
        return "redirect:/";
    }
    @GetMapping("search-by-title")
    public String searchByTitle() {
        return "searchByTitle";
    }
    @PostMapping("search-by-title")
    public String searchVlog(@RequestParam String title, Model model){
        List<Vlog> vlogs = vlogService.getVlogByTitle(title);
        System.out.println(vlogs);
        model.addAttribute("vlogs", vlogs);
        return "redirect:/search-by-title";
    }

}
