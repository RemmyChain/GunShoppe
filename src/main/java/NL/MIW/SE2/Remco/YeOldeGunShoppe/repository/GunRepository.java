package NL.MIW.SE2.Remco.YeOldeGunShoppe.repository;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Gun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * Author: Remco Ketting
 * Purpose of program: get and save guns
 */
public interface GunRepository extends JpaRepository<Gun, Long> {
    Optional<Gun> findGunByGunName(String gunName);

}
