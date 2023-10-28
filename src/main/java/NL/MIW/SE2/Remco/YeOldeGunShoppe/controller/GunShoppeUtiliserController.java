package NL.MIW.SE2.Remco.YeOldeGunShoppe.controller;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.DTO.AddUserDTO;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Ammo;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.GunShoppeUtiliser;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.repository.GunShoppeUtiliserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
@Controller
@RequiredArgsConstructor
public class GunShoppeUtiliserController {

    private final GunShoppeUtiliserRepository gunShoppeUtiliserRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/utiliser/newutiliser")
    private String getUtiliserForm(Model model){
        model.addAttribute("utilserDetails", new AddUserDTO());

        return "utiliserForm";
    }
    @PostMapping("/utiliser/newutiliser")
    private String saveUtiliser(@ModelAttribute("utilserDetails") AddUserDTO addUserDTO) {
        GunShoppeUtiliser newUtiliser = new GunShoppeUtiliser();
        if (addUserDTO.getPassword().equals(addUserDTO.getConfirmPassword())){
            newUtiliser.setUsername(addUserDTO.getUsername());
            newUtiliser.setPassword(passwordEncoder.encode(addUserDTO.getPassword()));
            gunShoppeUtiliserRepository.save(newUtiliser);
        }



        return "redirect:/";
    }


}
