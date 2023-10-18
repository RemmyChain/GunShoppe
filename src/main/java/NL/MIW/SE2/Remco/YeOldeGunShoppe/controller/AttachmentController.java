package NL.MIW.SE2.Remco.YeOldeGunShoppe.controller;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Ammo;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Attachment;
import NL.MIW.SE2.Remco.YeOldeGunShoppe.repository.AttachmentRepository;
import lombok.RequiredArgsConstructor;
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
public class AttachmentController {
    private final AttachmentRepository attachmentRepository;

    @GetMapping("/attachment/new")
    private String showAttachmentForm(Model model) {
        model.addAttribute("attachment", new Attachment());

        return "attachmentForm";
    }
    @PostMapping("/attachment/new")
    private String saveOrUpdateAttachment(@ModelAttribute("attachment") Attachment attachmentToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            attachmentRepository.save(attachmentToBeSaved);
        }

        return "redirect:/";
    }
}
