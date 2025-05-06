package tn.droidzed.ktoury.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {
    /**
     * Configures the security filter chain for handling HTTP requests, OAuth2 login, and logout.
     *
     * @param http HttpSecurity object to define web-based security at the HTTP level
     * @return SecurityFilterChain for filtering and securing HTTP requests
     * @throws Exception in case of an error during configuration
     */
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/login").permitAll()
                    .requestMatchers("/register").permitAll()
                    .requestMatchers("/forgot-pwd-*").permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .oauth2Login { oauth2: OAuth2LoginConfigurer<HttpSecurity?>? ->
                oauth2!!
                    .loginPage("/oauth2/authorization/keycloak")
                    .defaultSuccessUrl("/tours", true)
            }
            .logout { logout: LogoutConfigurer<HttpSecurity?>? ->
                logout!!
                    .logoutSuccessUrl("/") // Redirects to the root URL on successful logout
                    .invalidateHttpSession(true) // Invalidates session to clear session data
                    .clearAuthentication(true) // Clears authentication details
                    .deleteCookies("JSESSIONID")
            }

        return http.build()
    }
}
