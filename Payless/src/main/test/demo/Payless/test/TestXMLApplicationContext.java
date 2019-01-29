package demo.Payless.test;

import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import demo.Payless.model.Consumer;
import demo.Payless.model.Trader;
import demo.Payless.repositories.UsserRepository;

@Configuration
@Repository
public class TestXMLApplicationContext {

	@Autowired
	private UsserRepository repository;

	@Autowired
	private DataSource datasource;




	public static void main(String[] arg) throws URISyntaxException, Exception {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("configuration/spring-configuration.xml");

		try {


			TestXMLApplicationContext s = (TestXMLApplicationContext) ctx.getBean("mainBean");
			System.out.println("Add employees");
			s.addUser();
			System.out.println("Find all employees");

			/*s.findAllEmployees();
			System.out.println("Find employee by name �Joe�");
			s.findEmployee("Joe");
			System.out.println("Find employee by name �John�");
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


	public  void addUser(){
		Consumer consumer3 = new Consumer("JPAXML", "1021707", 22222, "JPAXML", "JPAXML");
		Trader trader1 = new Trader("sourise", "1234564", 132555  );
		repository.save(consumer3);
		repository.save(trader1);
	}




}
