package demo.Payless.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Indexed;

import demo.Payless.model.Usser;

@NoRepositoryBean
public interface UserBaseRepository<T extends Usser> extends CrudRepository<T, Long> {

	<S extends T> S save(S entity);

	Optional<T> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<T> findAll();

	Iterable<T> findAllById(Iterable<Long> ids);

	long count();

	void deleteById(Long id);

	void delete(T entity);

		
}
