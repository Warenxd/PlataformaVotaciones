package com.example.app.PlataformaVotaciones.config;

import com.example.app.PlataformaVotaciones.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl uds) {
        this.userDetailsService = uds;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/menu", "/css/**", "/js/**").permitAll()
                        .requestMatchers("/encuesta/**").authenticated()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        //.loginPage("/menu")       // Página con el formulario de login
                        .loginProcessingUrl("/login") // URL que procesa el login (por defecto)
                        .usernameParameter("emailUser")  // Nombre del input para email
                        .passwordParameter("password")
                        .defaultSuccessUrl("/encuesta", true)  // Redirige tras login exitoso
                        .failureUrl("/menu?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/menu?logout=true")
                )
                .userDetailsService(userDetailsService)
                .csrf(csrf -> csrf.disable()); // Opcional, para pruebas en local

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Sin codificación de contraseñas, compara texto plano
        return NoOpPasswordEncoder.getInstance();
    }
}
