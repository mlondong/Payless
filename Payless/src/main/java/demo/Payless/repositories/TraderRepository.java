package demo.Payless.repositories;

import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.Trader;

@Transactional
public interface TraderRepository extends UserBaseRepository<Trader>{

}
