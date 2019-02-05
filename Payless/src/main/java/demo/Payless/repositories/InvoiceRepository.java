package demo.Payless.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.Invoice;
import demo.Payless.model.Stock;


@Repository
@Transactional
@NoRepositoryBean
public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

	<S extends Invoice> S save(S entity);

	<S extends Invoice> Iterable<S> saveAll(Iterable<S> entities);

	Optional<Invoice> findById(Long id);

	boolean existsById(Long id);

	Iterable<Invoice> findAll();

	Iterable<Invoice> findAllById(Iterable<Long> ids);

	long count();

	void deleteById(Long id);

	void delete(Stock entity);

	void deleteAll();


}
