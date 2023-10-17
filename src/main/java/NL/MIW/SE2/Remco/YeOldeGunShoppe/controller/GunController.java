package NL.MIW.SE2.Remco.YeOldeGunShoppe.controller;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Gun;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.repository.GunRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Author: Remco Ketting
 * Purpose of program: handle gun database stuff
 */
@Controller
public class GunController {
  private final GunRepository gunRepository;

  public GunController(GunRepository gunRepository) {
    this.gunRepository = gunRepository;
  }

  @GetMapping
  private String gunsLotsAndLotsOfGuns(Model model){
    model.addAttribute("allGuns", gunRepository.findAll());

    return "showLotsOfGuns";
  }
  @GetMapping("/gun/new")
  private String showGunForm(Model model) {
    model.addAttribute("gun", new Gun());

    return "gunForm";
  }

  @PostMapping("/gun/new")
  private String saveOrUpdateGun(@ModelAttribute("gun") Gun gunToBeSaved, BindingResult result) {
    if (!result.hasErrors()) {
      gunRepository.save(gunToBeSaved);
    }

    return "redirect:/";
  }

}
