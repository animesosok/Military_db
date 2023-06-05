package ru.nsu.db.militarys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.db.militarys.entity.MilitaryBase;
import ru.nsu.db.militarys.repo.MilitaryBaseRepo;
import ru.nsu.db.militarys.repo.PersonRepo;
import ru.nsu.db.militarys.repo.UnitNameRepo;

@Controller
public class MilitaryBaseController {
    @Autowired
    private MilitaryBaseRepo baseRepo;

    @GetMapping("/military_base")
    public String basesMain (Model model){
        var bases = baseRepo.findAll();
        model.addAttribute("bases", bases);
        return "military_base-main";
    }
    @GetMapping("/military_base/insert")
    public String basesInsertView(Model model){

        return "military_base-insert";
    }
    @PostMapping("/military_base/insert")
    public String basesInsert(@RequestParam int unitId, @RequestParam int regionId, Model model){
        MilitaryBase base = new MilitaryBase(unitId, regionId);
        baseRepo.save(base);
        return "redirect:/military_base";
    }
    @PostMapping("/military_base/{id}/remove")
    public String delete(@PathVariable int id, Model model){
        baseRepo.deleteById((long) id);
        return "redirect:/military_base";
    }
}
