package Atm_demo.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmJpaRepoDao extends JpaRepository<AtmPojo, Integer>
{
	
}
