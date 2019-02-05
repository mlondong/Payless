package demo.Payless.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.CareProduct;
import demo.Payless.model.MeatProduct;

@Repository
@Transactional
public interface MeatProductRepository extends ProductBaseRepository<MeatProduct>  {

	List<MeatProduct> findByTypeAnimal(String animal);
	
}
