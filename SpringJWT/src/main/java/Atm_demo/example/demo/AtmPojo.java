package Atm_demo.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtmPojo 
{
	@Id
	//variables
	Integer accno;//To store account number
	String name;  //To store name
	int balance;  //To store balance
	
	//Getters
	public Integer getAccno() 
	{
		return accno;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public int getBalance() 
	{
		return balance;
	}
	
	
	//Setters
	public void setAccno(Integer accno) 
	{
		this.accno = accno;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	  public void setBalance(int balance)
	  { 
		  this.balance = balance; 
	}
	 
}
