package Atm_demo.example.demo;

import java.util.Optional;

public interface IAtm
{
	
	Optional<AtmPojo> withdraw(int acno,int atm);//update
	
	Optional<AtmPojo> deposit(int acno,int atm);//update
	
	Optional<AtmPojo> checkBalance(int accno);//get
	
	Optional<AtmPojo> checkDetails(int accno);//get
	
	AtmPojo updateDetails(AtmPojo a);//update
	
	AtmPojo createAccount(AtmPojo a);//post
	
	String deleteAccount(int acno);//delete
	
}
