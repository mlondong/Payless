package demo.Payless.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;


public interface AbstactRepository<T, ID extends Serializable> extends Repository<T, ID> {

	<S extends T> S save(S entity);

	T findOne(ID id);
	
	Iterable<T> findAll();
	
	void delete(ID id);


}
