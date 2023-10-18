package NL.MIW.SE2.Remco.YeOldeGunShoppe.controller;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Ammo;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.repository.AmmoRepository;

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
 * Purpose of program:
 */
@Controller
public class AmmoController {

    private final AmmoRepository ammoRepository;

    public AmmoController(AmmoRepository ammoRepository) {
        this.ammoRepository = ammoRepository;
    }

    @GetMapping("/ammo/new")
    private String showAmmoForm(Model model) {
        model.addAttribute("ammo", new Ammo());

        return "ammoForm";
    }
    @PostMapping("/ammo/new")
    private String saveOrUpdateAmmo(@ModelAttribute("ammo") Ammo ammoToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            ammoRepository.save(ammoToBeSaved);
        }

        return "redirect:/";
    }
    @GetMapping("/ammo/detail/{calibre}")
    private String showAmmoDetails(@PathVariable("calibre") String calibre, Model model) {
        Optional<Ammo> optionalAmmo = ammoRepository.findAmmoByAmmoName(calibre);

        if (optionalAmmo.isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("ammoToBeShown", optionalAmmo.get());

        return "ammoDetail";
    }
}
