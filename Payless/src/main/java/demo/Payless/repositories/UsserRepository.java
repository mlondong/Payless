package demo.Payless.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.QueryHint;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.Usser;

@Repository
@Transactional
public interface UsserRepository extends BaseUserRepository<Usser>{

	/*Metodos comunes a Usser y sus herederos*/
	Usser  findUsserById(long id);
	List<Usser> findUsserByName(String name);
	List<Usser> findUsserByState(boolean state);


}
