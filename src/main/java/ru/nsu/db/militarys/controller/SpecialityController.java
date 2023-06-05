package ru.nsu.db.militarys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.nsu.db.militarys.repo.SpecialityRepo;

@Controller
public class SpecialityController {
    @Autowired
    SpecialityRepo specialityRepo;

    @GetMapping
    public String getSpecialities(Model model){

        return "speciality/speciality-main";
    }
}
