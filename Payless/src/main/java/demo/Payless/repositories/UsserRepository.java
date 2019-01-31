package demo.Payless.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.QueryHint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.Usser;


@Transactional
public interface UsserRepository extends UserBaseRepository<Usser>{
	List<Usser> findEmployeesById(int age);
	List<Usser> findEmployeesByName(String name);
	List<Usser> findEmployeesByState(boolean state);
	/*Page<Usser> findEmployeesByAgeGreaterThan(int age, Pageable pageable);*/
}
