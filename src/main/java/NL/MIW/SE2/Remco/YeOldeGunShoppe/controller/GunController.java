package NL.MIW.SE2.Remco.YeOldeGunShoppe.controller;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Ammo;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Gun;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.repository.AmmoRepository;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.repository.GunRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * Author: Remco Ketting
 * Purpose of program: handle gun database stuff
 */
@Controller
public class GunController {
  private final GunRepository gunRepository;
  private final AmmoRepository ammoRepository;

  public GunController(GunRepository gunRepository, AmmoRepository ammoRepository) {
    this.gunRepository = gunRepository;
    this.ammoRepository = ammoRepository;
  }

  @GetMapping
  private String gunsLotsAndLotsOfGuns(Model model){
    model.addAttribute("allGuns", gunRepository.findAll());
    model.addAttribute("allAmmo", ammoRepository.findAll());

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
      Optional<Ammo> ammoOptional = ammoRepository.findAmmoByAmmoName(gunToBeSaved.getAmmoType());
      if (ammoOptional.isPresent()) {

        gunToBeSaved.setAmmo(ammoOptional.get());
        gunRepository.save(gunToBeSaved);
      }



    }

    return "redirect:/";
  }
  @GetMapping("/gun/new/{ammoId}")
  private String createNewGun(@PathVariable("ammoId") Long ammoId) {
    Optional<Ammo> ammoOptional = ammoRepository.findById(ammoId);

    if (ammoOptional.isPresent()) {
      Gun gun = new Gun();
      gun.setAmmo(ammoOptional.get());
      gunRepository.save(gun);
    }

    return "redirect:/";
  }

}
