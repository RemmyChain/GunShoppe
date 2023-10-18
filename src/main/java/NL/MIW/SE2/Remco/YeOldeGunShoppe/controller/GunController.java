package NL.MIW.SE2.Remco.YeOldeGunShoppe.controller;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Ammo;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Gun;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.repository.AmmoRepository;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.repository.AttachmentRepository;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.repository.GunRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Author: Remco Ketting
 * Purpose of program: handle gun database stuff
 */
@Controller
public class GunController {
  private final GunRepository gunRepository;
  private final AmmoRepository ammoRepository;
  private final AttachmentRepository attachmentRepository;

  public GunController(GunRepository gunRepository, AmmoRepository ammoRepository, AttachmentRepository attachmentRepository) {
    this.gunRepository = gunRepository;
    this.ammoRepository = ammoRepository;
    this.attachmentRepository = attachmentRepository;
  }

  @GetMapping
  private String gunsLotsAndLotsOfGuns(Model model){
    List<Gun> sortedGuns = gunRepository.findAll();
    Collections.sort(sortedGuns);
    model.addAttribute("allGuns", sortedGuns);
    model.addAttribute("allAmmo", ammoRepository.findAll());

    return "showLotsOfGuns";
  }
  @GetMapping("/gun/new")
  private String showGunForm(Model model) {
    model.addAttribute("gun", new Gun());
    model.addAttribute("ammoList", ammoRepository.findAll());
    model.addAttribute("attachmentList", attachmentRepository.findAll());

    return "gunForm";
  }

  @GetMapping("/gun/edit/{gunName}")
  private String showEditGunForm(@PathVariable("gunName") String gunName, Model model) {
    Optional<Gun> optionalGun = gunRepository.findGunByGunName(gunName);

    if (optionalGun.isEmpty()) {
      return "redirect:/";
    }

    model.addAttribute("gun", optionalGun.get());
    model.addAttribute("attachmentList", attachmentRepository.findAll());
    model.addAttribute("ammoList", ammoRepository.findAll());

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
