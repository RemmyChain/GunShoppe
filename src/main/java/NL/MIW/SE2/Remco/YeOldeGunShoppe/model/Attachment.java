package NL.MIW.SE2.Remco.YeOldeGunShoppe.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Author: Remco Ketting
 * Purpose of program: attachments to pimp up your firearms
 */
@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Attachment {
    @Id @GeneratedValue
    private Long attachmentId;
    private String attachmentName;
}
