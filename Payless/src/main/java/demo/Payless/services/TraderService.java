package demo.Payless.services;
import demo.Payless.model.Trader;
import demo.Payless.repositories.TraderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("TraderService")
public class TraderService {

	@Autowired
	private TraderRepository traderRepo;

	@Transactional
	public void create(Trader t) {
		traderRepo.save(t);
	}

}
