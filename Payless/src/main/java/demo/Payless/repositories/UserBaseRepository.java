package demo.Payless.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import demo.Payless.model.Usser;

@NoRepositoryBean
public interface UserBaseRepository<T extends Usser> extends Repository<T, Long> {

	<S extends T> S save(S entity);

	Iterable<T> findAll();
	
	Long count();
	
}
