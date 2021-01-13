// package net.javaguides.springboot.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// import lombok.AllArgsConstructor;
// import net.javaguides.springboot.service.UserDetailsServiceImpl;
// import static net.javaguides.springboot.model.Roles.*;

// @EnableWebSecurity
// @AllArgsConstructor
// public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

// private UserDetailsServiceImpl userDetailsService;

// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http.cors().and().csrf().disable().authorizeRequests()
// .antMatchers(HttpMethod.POST, "/api/auth/user/sign-up").permitAll()
// .antMatchers(HttpMethod.POST, "/api/auth/customer/sign-up").permitAll()
// .antMatchers("/api/product/**").hasAnyAuthority(CUSTOMER.name(),
// ADMIN.name())
// .antMatchers(HttpMethod.DELETE,
// "/api/account/delete").hasAuthority(ADMIN.name())
// .anyRequest().authenticated().and()
// .addFilter(new JWTAuthenticationFilter(authenticationManager()))
// .addFilter(new JWTAuthorizationFilter(authenticationManager()))
// // this disables session creation on Spring Security
// .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// }

// @Override
// public void configure(AuthenticationManagerBuilder auth) throws Exception {
// auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
// }

// @Bean
// CorsConfigurationSource CorsConfigurationSource() {
// final UrlBasedCorsConfigurationSource source = new
// UrlBasedCorsConfigurationSource();

// source.registerCorsConfiguration("/**", new
// CorsConfiguration().applyPermitDefaultValues());

// return source;
// }

// @Bean
// public BCryptPasswordEncoder bCryptPasswordEncoder() {
// return new BCryptPasswordEncoder();
// }

// @Bean
// public AuthenticationManager authenticationManagerBean() throws Exception {
// return super.authenticationManagerBean();
// }
// }
