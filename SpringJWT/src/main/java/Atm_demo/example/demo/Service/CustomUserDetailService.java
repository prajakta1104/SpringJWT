


package Atm_demo.example.demo.Service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService
{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		if(username.equals("prajakta"))
		{
			return new User("prajakta","prajakta@123",new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("Username not found");
		}
		
	}

}
