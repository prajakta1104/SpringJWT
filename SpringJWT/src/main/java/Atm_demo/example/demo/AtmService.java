package Atm_demo.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtmService implements IAtm
{
	@Autowired
	private AtmJpaRepoDao atmdao;

	//This method is used to withdraw money from account
	@Override
	public Optional<AtmPojo> withdraw(int acno,int amt) 
	{
		AtmPojo a;
		Optional<AtmPojo> entity=atmdao.findById(acno);
		if(entity.isPresent())
		{
			a=entity.get();
			a.balance=a.balance-amt;
			atmdao.save(a);
		}
		
		return entity;
	}

	//This method is used to Deposite Money from account
	@Override
	public Optional<AtmPojo> deposit(int acno,int amt) 
	{
		AtmPojo a;
		Optional<AtmPojo> entity=atmdao.findById(acno);
		if(entity.isPresent())
		{
			a=entity.get();
			a.balance=a.balance+amt;
			atmdao.save(a);
			
		}
		
		return entity;
		
	}

	
	//This method is used to Check balance of account
	@Override
	public Optional<AtmPojo> checkBalance(int accno) 
	{
		return atmdao.findById(accno);
	}

	
	//This method is used to check account details 
	@Override
	public Optional<AtmPojo> checkDetails(int accno) 
	{
		return atmdao.findById(accno);
	}

	//This method is used to Update account
	@Override
	public AtmPojo updateDetails(AtmPojo a) 
	{
		return atmdao.save(a);
		
	}

	//This method is used to create account
	@Override
	public AtmPojo createAccount(AtmPojo a) 
	{
		return atmdao.save(a);
	}

	
	//This method is used to delete account
	@Override
	public String deleteAccount(int acno) 
	{
		Optional<AtmPojo> entity= atmdao.findById(acno);
		if(entity.isPresent())
		{
			atmdao.delete(entity.get());
			return "Account Deleted Sucessfully";
		}
		return "Accout not found";
	}
	

}
