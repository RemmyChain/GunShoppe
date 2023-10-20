package NL.MIW.SE2.Remco.YeOldeGunShoppe.config;

import NL.MIW.SE2.Remco.YeOldeGunShoppe.service.GunShoppeUtiliserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Author: Remco Ketting
 * Purpose of program: handle the security system
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class GunSafety {

    private final GunShoppeUtiliserDetailService utiliserDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorize) -> authorize
                        .antMatchers("/css/**", "/webjars/**").permitAll()
                        .antMatchers("/initialize").permitAll()
                        .antMatchers("/").permitAll()
                        .antMatchers("/images/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin().and()
                .logout().logoutSuccessUrl("/");

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(utiliserDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }



}
