package demo.Payless.test;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.Consumer;
import demo.Payless.model.Invoice;
import demo.Payless.model.Stock;
import demo.Payless.model.StockProducId;
import demo.Payless.model.StockProducts;
import demo.Payless.model.Trader;
import demo.Payless.model.Usser;
import demo.Payless.repositories.ConsumerRepository;
import demo.Payless.repositories.TraderRepository;
import demo.Payless.repositories.UserBaseRepository;
import demo.Payless.repositories.UsserRepository;

@Configuration
@Repository
public class TestXMLApplicationContext {

	@Autowired
	private UsserRepository userRepo;

	@Autowired
	private TraderRepository traderRepo;

	public static void main(String[] arg) throws URISyntaxException, Exception {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("configuration/spring-configuration.xml");

		try {


			TestXMLApplicationContext bean = (TestXMLApplicationContext)ctx.getBean("mainBean");
			System.out.println("iniciando....");
			
			System.out.println("Find all employees");
			
			Trader us = (Trader)bean.findUser(1L);
			Stock st = us.getStock();
			Collection<Invoice> in = us.getInvoices();
			
			
			System.out.println("Stock " + st.getId());
		//	findStock();	
			
			
			
			
			/*s.findAllEmployees();
			System.out.println("Find employee by name ’Joe’");
			s.findEmployee("Joe");
			System.out.println("Find employee by name ’John’");
			s.findEmployee("John");
			System.out.println("Find employees by age");
			s.findEmployeesByAge(32);
			System.out.println("Find employees between 30 and 45");
			s.findEmployeesBetweenAge(30, 45);
			System.out.println("Find employees greater than 20");
			s.findEmployeesGreaterThanAgePageWise(20, 1, 0);
			s.findEmployeesGreaterThanAgePageWise(20, 1, 1);
			s.findEmployeesGreaterThanAgePageWise(20, 2, 0);
			s.findEmployeesGreaterThanAgePageWise(20, 2, 1);*/

		}finally{
			ctx.close();
		
		}
	}


		
	public Usser findUser(long id){
		return userRepo.findUsserById(id);
	}
	
	
	public List<Usser> findUsserByName(String name){
		return userRepo.findUsserByName(name);
	}
	
	public  void addUser(){
		Usser consumer3 = new Consumer("0000", "0000", 22222, "3DIAS", "3DIAS");
		Usser trader1 = new Trader("11111", "8888", 132555  );
		userRepo.save(consumer3);
		userRepo.save(trader1);
	}




}
