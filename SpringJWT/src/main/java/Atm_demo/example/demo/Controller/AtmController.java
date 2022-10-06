package Atm_demo.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Atm_demo.example.demo.AtmPojo;
import Atm_demo.example.demo.IAtm;

@RestController
public class AtmController 
{

	@Autowired
	private IAtm iatm;

	//This method is used to withdraw money from account
	@PostMapping (value ="/Atmw/{acno}/{amt}")
	Optional<AtmPojo> withdraw (@PathVariable ("acno") int acno,@PathVariable("amt") int amt)
	{
		Optional<AtmPojo> atm = iatm.withdraw(acno,amt);
		return atm;
	}

	//This method is used to Deposit Money from account
	@PostMapping (value ="/Atmd/{acno}/{amt}")
	Optional<AtmPojo> deposit (@PathVariable ("acno") int acno,@PathVariable("amt") int amt)
	{
		Optional<AtmPojo> atm = iatm.deposit(acno,amt);
		return atm;
	}

    //This method is used to create account
	@PostMapping(value="Atm")
	AtmPojo createAccount(@RequestBody AtmPojo a)
	{
		AtmPojo atm=iatm.createAccount(a);
		return atm;
	}
	
	
	//This method is used to Update account
	@PostMapping(value="/Atm/{acno}")
	AtmPojo updateDetails(@RequestBody AtmPojo a)
	{
		AtmPojo atm=iatm.updateDetails(a);
		return atm;

	}

	//This method is used to check account details
	@GetMapping(value="Atm/{acno}")
	public AtmPojo checkDetails(@PathVariable("acno") int acno)
	{
		Optional<AtmPojo> atm=iatm.checkDetails(acno);
		return atm.isPresent()?atm.get():new AtmPojo();
	}

	//This method is used to Check balance of account
	@GetMapping(value = "Atmb/{acno}")
	AtmPojo checkBalance(@PathVariable ("acno") int acno)
	{
		Optional<AtmPojo> atm = iatm.checkBalance(acno);
		return atm.isPresent()?atm.get():new AtmPojo();  

	}
	
	//This method is used to delete account
	@DeleteMapping(value="Atm/{acno}")
	String delete(@PathVariable ("acno") int acno)
	{
		return iatm.deleteAccount(acno);
	}

}
