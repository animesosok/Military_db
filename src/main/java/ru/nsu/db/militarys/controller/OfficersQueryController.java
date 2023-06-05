package ru.nsu.db.militarys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.db.militarys.entity.Person;
import ru.nsu.db.militarys.repo.MilitaryUnitRepo;
import ru.nsu.db.militarys.repo.PersonRepo;

import java.util.List;

@Controller
public class OfficersQueryController {


    @Autowired
    PersonRepo personRepo;
    @Autowired
    MilitaryUnitRepo unitRepo;
    @GetMapping("/query/officers")
    public String officerQuery(Model model){
        var units = unitRepo.findAll();
        model.addAttribute("units", units);
        model.addAttribute("persons", null);
        return "query/officers-query";
    }
    @PostMapping("/query/officers")
    public String officerQueryPost(@RequestParam String unitId, Model model){
        int id = 0;
        List<Person> persons = null;
        if (unitId.length()>0){
            id = Integer.parseInt(unitId);
            if (unitRepo.existsById((long) id)){
                persons = personRepo.findAllByRank_isOfficerAndServeUnitId(true, id);
            }
        }
        else {
            persons = personRepo.findAllByRank_isOfficer(true);
        }
        model.addAttribute("persons", persons);
        var units = unitRepo.findAll();
        model.addAttribute("units", units);
        return "query/officers-query";
    }
}
