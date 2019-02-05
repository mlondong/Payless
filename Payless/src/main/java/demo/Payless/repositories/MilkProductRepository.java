package demo.Payless.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.MeatProduct;
import demo.Payless.model.MilkProduct;

@Repository
@Transactional
public interface MilkProductRepository extends ProductBaseRepository<MilkProduct>{

}
