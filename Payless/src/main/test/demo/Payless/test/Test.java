package demo.Payless.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.internal.DriverConnectionCreator;

import demo.Payless.dao.AbstractDAO;
import demo.Payless.dao.HibernateUtil;
import demo.Payless.model.CareProduct;
import demo.Payless.model.Consumer;
import demo.Payless.model.Invoice;
import demo.Payless.model.MeatProduct;
import demo.Payless.model.MilkProduct;
import demo.Payless.model.Product;
import demo.Payless.model.Purchase;
import demo.Payless.model.Trader;

public class Test {


	public static void main(String[] arg){
		//testDB();
		//testEntity();
		//testpersistence();
		//testConsumerAndPurchase();
		testCompletoConsumer();
		//otros();
		
	}


	public static void testCompletoConsumer(){
		Consumer consumer = new Consumer("XMEN", "0000001", 111111, "PEdro", "Sanchez");
		Purchase compra1 = new Purchase(new Date(),21563);
		MeatProduct mp5 = new MeatProduct("MP1212", "Carne de Pollo", "Pollo", 50, 10, "Pollo", new Date() );

		compra1.addProduct(mp5);
		consumer.getPurchase().add(compra1);
		AbstractDAO.almacenaEntidad(consumer);
	
	} 
	
	
	public static void testConsumerAndPurchase(){

		Consumer consumer = new Consumer("mouse", "1234564", 10217047, "Mauricio", "londono");
		Purchase compra1 = new Purchase(new Date(),5555);
		Purchase compra2 = new Purchase(new Date(),54212);
		consumer.getPurchase().add(compra1);
		consumer.getPurchase().add(compra2);
		AbstractDAO.almacenaEntidad(consumer);


		Consumer consumer2 = new Consumer("Lorena", "1021707", 22222, "Lorena", "londono");
		Purchase compra3 = new Purchase(new Date(),4444);
		consumer2.getPurchase().add(compra3);
		AbstractDAO.almacenaEntidad(consumer2);


	}

	
	
	
	public static void otros(){
		/*

		 * ///MilkProduct mp2 =  new MilkProduct("MP23", "Leche Entera", "Celema", 100, 50 );

		 * 		MeatProduct mp1 = new MeatProduct("MPJU123", "Carne de vaca", "Angus", 50, 10, "Vaca", new Date() );
	MilkProduct mp2 =  new MilkProduct("MP23", "Leche Entera", "Celema", 100, 50 );
	MeatProduct mp3 = new MeatProduct("MPAA123", "Carne de vaca", "Angus", 50, 10, "Vaca", new Date() );
	MeatProduct mp4 = new MeatProduct("MPCP121", "Carne de vaca", "Brangus", 50, 10, "Vaca", new Date() );
	MeatProduct mp5 = new MeatProduct("MP1212", "Carne de Pollo", "Pollo", 50, 10, "Pollo", new Date() );

		 * 
		 * 	MeatProduct mp = new MeatProduct("MPJU123", "Carne de vaca", "Angus", 50, 10, "Vaca", new Date() );
	MilkProduct m =  new MilkProduct("MP23", "Leche Entera", "Celema", 100, 50 );
	
	Invoice in = new Invoice();
	in.setDateInvoice(new Date());
	in.addProduct(new MeatProduct("MPJU123", "Carne de vaca", "Angus", 50, 10, "Vaca", new Date() ));
	in.addProduct(new MilkProduct("MP23", "Leche Entera", "Celema", 100, 50 ));


	AbstractDAO.almacenaEntidad(in);



		 * 
		 * */	


		/*		CareProduct cp = new CareProduct("CPJU123", "Jabon de bano", "Dove", 100, 50);
	AbstractDAO.almacenaEntidad(cp);

	MeatProduct mp = new MeatProduct("MPJU123", "Carne de vaca", "Angus", 50, 10, "Vaca", new Date());
	AbstractDAO.almacenaEntidad(mp);

	MilkProduct m =  new MilkProduct("MP23", "Leche Entera", "Celema", 100, 50);
	AbstractDAO.almacenaEntidad(m);
		 */

	}	



	
	public static void testEntity(){
		/*TESTDE HIBERNATE*/
		//Consumer c = new Consumer("mouse", "1234564", 10217047, "Mauricio", "londono");
		//AbstractDAO.almacenaEntidad(c);

		Trader t = new Trader("sourise", "1234564", 132555);
		AbstractDAO.almacenaEntidad(t);

	}



	public static void testDB(){
		String jdbc="jdbc:mysql://localhost:3306/dbpayless?useSSL=false";
		String  user= "payless";
		String pass="payless123";
		System.out.println("Conectando a BD...");

		try{
			Connection c = DriverManager.getConnection(jdbc, user, pass);
			System.out.println("Conexion successful");

		}catch(Exception e){
			System.out.println("Error de conexion " + e);
		}

	}




	public static void testpersistence(){
		SessionFactory factory;
		factory = new Configuration()
				.configure("hibernate/hibernate.cfg.xml")
				.addAnnotatedClass(Consumer.class)
				.buildSessionFactory();

		Session session = factory.openSession();


		Consumer c = new Consumer("mouse2", "11111", 1000, "Mauxxx", "londono");

		try {

			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();

		} finally  {

			factory.close();
		}


	}

}
