package ru.nsu.db.militarys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.db.militarys.entity.MilitaryUnit;
import ru.nsu.db.militarys.entity.Person;
import ru.nsu.db.militarys.repo.MilitaryUnitRepo;
import ru.nsu.db.militarys.repo.PersonRepo;
import ru.nsu.db.militarys.repo.RankRepo;

@Controller
public class PersonController {
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private MilitaryUnitRepo unitRepo;
    @Autowired
    private RankRepo rankRepo;
    @GetMapping("/person")
    public String basesMain (Model model){
        var persons= personRepo.findAll();
        model.addAttribute("persons", persons);
        return "person/person-main";
    }
    @GetMapping("/person/insert")
    public String basesInsertView(Model model){
        var units = unitRepo.findAll();
        model.addAttribute("units", units);
        var ranks = rankRepo.findAll();
        model.addAttribute("ranks", ranks);
        return "person/person-insert";
    }
    @PostMapping("/person/insert")
    public String basesInsert(@RequestParam  int personId, @RequestParam String lastName,@RequestParam String firstName,@RequestParam String fatherName,@RequestParam String birthday,
                              @RequestParam  int  rankId, @RequestParam  int  serveUnitId, Model model){
        Person person = new Person();
        personRepo.save(person);
        return "redirect:/person";
    }
    @PostMapping("/person/{id}/remove")
    public String delete(@PathVariable int id, Model model){
        personRepo.deleteById((long) id);
        return "redirect:/person";
    }
}
