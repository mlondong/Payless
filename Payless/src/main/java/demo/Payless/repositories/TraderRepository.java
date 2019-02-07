package demo.Payless.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.Consumer;
import demo.Payless.model.Trader;
import demo.Payless.model.Stock;

@Repository
@Transactional
public interface TraderRepository extends BaseUserRepository<Trader>{

	List<Consumer> findByCuit(int dni);
	List<Trader> findByStock(Stock stock);
	
}
