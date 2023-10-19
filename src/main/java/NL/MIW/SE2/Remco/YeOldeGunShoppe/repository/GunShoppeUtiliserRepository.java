package NL.MIW.SE2.Remco.YeOldeGunShoppe.repository;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.model.GunShoppeUtiliser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Author: Remco Ketting
 * Purpose of program: bin full of users
 */
public interface GunShoppeUtiliserRepository extends JpaRepository<GunShoppeUtiliser, Long> {
    Optional<GunShoppeUtiliser> findGunShoppeUtiliserByUsername(String username);

}
