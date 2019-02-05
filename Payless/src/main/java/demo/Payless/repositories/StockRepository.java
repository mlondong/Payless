package demo.Payless.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import demo.Payless.model.Stock;

public interface StockRepository extends CrudRepository<Stock, Long>{
	
	<S extends Stock> S save(S entity);

	<S extends Stock> Iterable<S> saveAll(Iterable<S> entities);

	Optional<Stock> findById(Long id);

	boolean existsById(Long id);

	Iterable<Stock> findAll();

	Iterable<Stock> findAllById(Iterable<Long> ids);

	 long count();

	void deleteById(Long id);

	void delete(Stock entity);
	
	void deleteAll();

	
	
}
