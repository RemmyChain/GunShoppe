package NL.MIW.SE2.Remco.YeOldeGunShoppe.repository;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.Ammo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public interface AmmoRepository extends JpaRepository<Ammo, Long> {
    Optional<Ammo> findAmmoByAmmoName(String ammoName);
}
