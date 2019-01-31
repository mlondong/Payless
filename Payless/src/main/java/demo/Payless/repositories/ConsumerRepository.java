package demo.Payless.repositories;

import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.Consumer;

@Transactional
public interface ConsumerRepository  extends UserBaseRepository<Consumer>{

}
