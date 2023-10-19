package NL.MIW.SE2.Remco.YeOldeGunShoppe.controller;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.GunShoppeUtiliser;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.repository.GunShoppeUtiliserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: Remco Ketting
 * Purpose of program: set up user with access
 */
@Controller
@RequiredArgsConstructor
public class AccessController {
    private final GunShoppeUtiliserRepository gunShoppeUtiliserRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/initialize")
    private String initializeDB() {
        if (!gunShoppeUtiliserRepository.findAll().isEmpty()) {
            return "redirect:/";
        }

        GunShoppeUtiliser uberuser = new GunShoppeUtiliser();
        uberuser.setUsername("chainiac");
        uberuser.setPassword(passwordEncoder.encode("l33th4x0r"));

        gunShoppeUtiliserRepository.save(uberuser);

        return "redirect:/";
    }

}
