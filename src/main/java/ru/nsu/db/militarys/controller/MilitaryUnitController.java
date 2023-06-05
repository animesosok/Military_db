package ru.nsu.db.militarys.controller;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nsu.db.militarys.entity.MilitaryUnit;
import ru.nsu.db.militarys.repo.MilitaryUnitRepo;
import ru.nsu.db.militarys.repo.PersonRepo;
import ru.nsu.db.militarys.repo.UnitNameRepo;
import ru.nsu.db.militarys.service.MilitaryUnitService;

import java.util.Optional;

@Controller
public class MilitaryUnitController {
    @Autowired
    private MilitaryUnitRepo unitRepo;
    @Autowired
    private UnitNameRepo unitNameRepo;
    @Autowired
    private PersonRepo personRepo;
   /// @Autowired
  //  private MilitaryUnitService service;
    @GetMapping("/military_unit")
    public String basesMain (Model model){
        var units = unitRepo.findAll();
        model.addAttribute("units", units);
        return "military_unit/military_unit-main";
    }
    @GetMapping("/military_unit/insert")
    public String basesInsertView(Model model){
        var unitNames = unitNameRepo.findAll();
        model.addAttribute("unitNames", unitNames);
        var persons = personRepo.findAll();
        model.addAttribute("persons", persons);
        var units = unitRepo.findAll();
        model.addAttribute("units", units);
        return "military_unit/military_unit-insert";
    }
    @PostMapping("/military_unit/insert")
    public String basesInsert(@RequestParam long unitNameId, @RequestParam long commanderId, @RequestParam @Nullable String parentUnit, Model model){
        MilitaryUnit unit = new MilitaryUnit();
        var unitName = unitNameRepo.findById(unitNameId);
        if (unitName.isPresent()){
            unit.setUnitName(unitName.get());
        }
        var commander = personRepo.findById(commanderId);
        if(commander.isPresent()){
            unit.setCommander(commander.get());
        }
        if (parentUnit.length() != 0){
            unit.setParentUnit(Integer.parseInt(parentUnit));
        }

        unitRepo.save(unit);
        return "redirect:/military_unit";
    }
    @PostMapping("/military_unit/{id}/remove")
    public String delete(@PathVariable int id, Model model){
        if (unitRepo.existsById((long) id)) {
            unitRepo.deleteById((long) id);
        }
        return "redirect:/military_unit";
    }
    @GetMapping("/military_unit/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        if (!unitRepo.existsById((long) id)){
            return "redirect:/military_unit";
        }
        var unitNames = unitNameRepo.findAll();
        model.addAttribute("unitNames", unitNames);
        var persons = personRepo.findAll();
        model.addAttribute("persons", persons);
        var units = unitRepo.findAll();
        model.addAttribute("units", units);
        var unit = unitRepo.findById((long) id);
        model.addAttribute("unit", unit.get());
        return "military_unit/military_unit-edit";
    }
    @PostMapping("/military_unit/{id}/edit")
    public String editPost(@PathVariable int id, @RequestParam long unitNameId, @RequestParam long commanderId, @RequestParam @Nullable String parentUnit, Model model){
        Optional<MilitaryUnit> unitopt = unitRepo.findById(Long.valueOf(id));
        if (unitopt.isPresent()) {
            var unit = unitopt.get();
            var unitName = unitNameRepo.findById(unitNameId);
            if (unitName.isPresent()){
                unit.setUnitName(unitName.get());
            }
            var commander = personRepo.findById(commanderId);
            if(commander.isPresent()){
                unit.setCommander(commander.get());
            }
            if (parentUnit.length() != 0){
                unit.setParentUnit(Integer.parseInt(parentUnit));
            }
            unitRepo.save(unit);
        }
        return "redirect:/military_unit";
    }

}
