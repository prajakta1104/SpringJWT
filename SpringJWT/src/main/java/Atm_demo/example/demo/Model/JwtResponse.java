package Atm_demo.example.demo.Model;

public class JwtResponse 
{
	String token;
	
	public JwtResponse()
	{
		
	}
	
	public String getToken() 
	{
		return token;
	}

	public void setToken(String token) 
	{
		this.token = token;
	}

	public JwtResponse(String token)
	{
		this.token=token;
		
	}
}

