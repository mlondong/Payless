package demo.Payless.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.QueryHint;

import org.springframework.data.repository.NoRepositoryBean;

import demo.Payless.model.Usser;


@NoRepositoryBean
public interface UsserRepository extends AbstactRepository<Usser, Long>{
	
	List<Usser> findEmployeesById(int age);

	List<Usser> findEmployeesByName(String name);
	
	List<Usser> findEmployeesByState(boolean state);

	
	/*Page<Usser> findEmployeesByAgeGreaterThan(int age, Pageable pageable);*/
	

	
	
}
