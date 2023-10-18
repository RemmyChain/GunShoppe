package NL.MIW.SE2.Remco.YeOldeGunShoppe.repository;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Gun;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * Author: Remco Ketting
 * Purpose of program: get and save guns
 */
public interface GunRepository extends JpaRepository<Gun, Long> {

}
