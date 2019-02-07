package demo.Payless.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.Consumer;
import demo.Payless.model.Purchase;


@Repository
@Transactional
public interface ConsumerRepository  extends BaseUserRepository<Consumer>{

	/*CONSULTAS PROPIEDADES*/
	List<Consumer> findByDni(int dni);
	List<Consumer> findByFirstName(String firstName);


	/*CONSULTAS LIKE*/
	List<Consumer> findByLastNameIsLike(String lastName);
	List<Consumer> findByFirstNameLike(String lastName);


	/*OTRAS CONSULTAS DE OBJETOS*/
	List<Consumer> findByPurchase(Purchase p);

	
}
