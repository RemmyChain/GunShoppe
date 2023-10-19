package NL.MIW.SE2.Remco.YeOldeGunShoppe.service;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.repository.GunShoppeUtiliserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Author: Remco Ketting
 * Purpose of program: provide utiliser details
 */
@Service
@RequiredArgsConstructor
public class GunShoppeUtiliserDetailService implements UserDetailsService {

    private final GunShoppeUtiliserRepository gunShoppeUtiliserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return gunShoppeUtiliserRepository.findGunShoppeUtiliserByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("I don't know this person, sir!")
        );

    }
}
