package Atm_demo.example.demo.config;

import java.beans.JavaBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import Atm_demo.example.demo.Service.CustomUserDetailService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguraton extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	private  CustomUserDetailService customeruserdetailservice; 
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
				.csrf()
				.disable()
				.cors()
				.disable()
				.authorizeRequests()
				.antMatchers("/token").permitAll()
				.anyRequest().authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				
		
	}
	
	
	@Bean
	  @Override 
	  protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception {
	 auth.userDetailsService(customeruserdetailservice);
	  }
	  
	  
	  @Bean 
	  public PasswordEncoder passwordEncoder() {
	  
	  return NoOpPasswordEncoder.getInstance();
	  
	  }
	  
	  
	  @Bean
	  public AuthenticationManager authenticationManagerBean() throws Exception
	  {
		return super.authenticationManagerBean();
		  
	  }
	 
	 
}
