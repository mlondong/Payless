package demo.Payless.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.CareProduct;



@Repository
@Transactional
public interface CareProductRepository extends ProductBaseRepository<CareProduct> {

}
