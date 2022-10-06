package Atm_demo.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Atm_demo.example.demo.Model.JwtRequest;
import Atm_demo.example.demo.Model.JwtResponse;
import Atm_demo.example.demo.Service.CustomUserDetailService;
import helper.JwtUtil;

@RestController
public class JwtController 
{

	@Autowired	
	private AuthenticationManager authenticationmanager;

	@Autowired
	private CustomUserDetailService customuserdetailservice;


	private JwtUtil jwtutil;

	@PostMapping(value="/token")
	ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtrequest) throws Exception
	{
		try 
		{
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(jwtrequest.getUsername(), jwtrequest.getPassword()));
		}
		catch(UsernameNotFoundException e)
		{
			throw new Exception("Bad Credentials");
		}

		UserDetails userdetails=  customuserdetailservice.loadUserByUsername(jwtrequest.getUsername());

		String token=jwtutil.generateToken(userdetails);

		System.out.println("JwtToken "+token);

		return ResponseEntity.ok(new JwtResponse(token));
	}
}
