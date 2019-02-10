package demo.Payless.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import demo.Payless.dao.AbstractDAO;
import demo.Payless.dao.HibernateUtil;
import demo.Payless.model.Address;
import demo.Payless.model.CareProduct;
import demo.Payless.model.Consumer;
import demo.Payless.model.Invoice;
import demo.Payless.model.MeatProduct;
import demo.Payless.model.MilkProduct;
import demo.Payless.model.Product;
import demo.Payless.model.Purchase;

import demo.Payless.model.Stock;
import demo.Payless.model.StockProducts;
import demo.Payless.model.Trader;
import demo.Payless.model.Usser;

public class Test {


	public static void main(String[] arg){

		/*****POBLADO DE LA TABLA****/
		//createUsersandProducts();



		/*******TEST DE CONSUMERS****/
		//testConsumerALL();
		//testConsumerPurchaseProducts();			





		/*******TEST DE TRADERS****/
		/*testAddressTreader();
		testStockTraderProducts();
		testAddProductsStock();
		testDeleteProductsStock();
		testUdateProductsStock();
		testTraderInvoice();
		testTraderInvoiceProducts();*/


	}




	public static void createUsersandProducts(){

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Trader trader1 = new Trader("Trader1", "111111", 132555 ,null );
		Trader trader2 = new Trader("Trader2", "2222", 132555,null  );
		Consumer consumer1 = new Consumer("Consumer1", "9999", 10217047, "Fabio", "londono");
		Consumer consumer2 = new Consumer("Consumer2", "888", 10217047, "Martha", "Garcia");

		em.persist(trader1);
		em.persist(trader2);
		em.persist(consumer1);
		em.persist(consumer2);

		MeatProduct mp1 = new MeatProduct("MP1", "Vaca", "Angus",  10, "Vaca", new Date() );
		MeatProduct mp2 = new MeatProduct("MP2", "Pollo", "Angus",  10, "Pollo", new Date() );
		MeatProduct mp3 = new MeatProduct("MP3", "Cerdo", "Cerdo",  10, "Cerdo", new Date() );
		MeatProduct mp4 = new MeatProduct("MP4", "Pez", "Pez",  10, "Pez", new Date() );

		em.persist(mp1);
		em.persist(mp2);
		em.persist(mp3);
		em.persist(mp4);

		MilkProduct mp5 =  new MilkProduct("MP5", "Leche Entera", "Celema",  50 );
		MilkProduct mp6 =  new MilkProduct("MP6", "Quesillo", "Celema",  50 );
		MilkProduct mp7 =  new MilkProduct("MP7", "Yogurth", "Celema",  50 );

		em.persist(mp5);
		em.persist(mp6);
		em.persist(mp7);

		CareProduct mp8 = new CareProduct("MP8", "Jabon de Manos", "Dove",  100);
		CareProduct mp9 = new CareProduct("MP9", "Shampoo", "Dove",  100);

		em.persist(mp8);
		em.persist(mp9);

		em.getTransaction().commit();
		em.close();		

	}



	/*************************************************************************************************/	
	/*INICIO DE LAS PRUEBAS PARA CONSUMER*/	
	/*************************************************************************************************/	


	public static void testConsumerALL(){
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		/*CREA 2 PURCHASE EN CONSUMER SIN PRODUCTOS*/
		Consumer c1 = em.getReference(Consumer.class, 4L);
	
		Purchase p1 = new Purchase();
		p1.setConsumer(c1);
		p1.addProductInPurchaseProduct(em.getReference(MeatProduct.class, 1L), 2);
		p1.addProductInPurchaseProduct(em.getReference(MilkProduct.class, 6L), 3);
		p1.addProductInPurchaseProduct(em.getReference(MeatProduct.class, 3L), 3);	
		
		
		Purchase p2 = new Purchase();
		p2.setConsumer(c1);
		p2.addProductInPurchaseProduct(em.getReference(CareProduct.class, 8L), 10);
		p2.addProductInPurchaseProduct(em.getReference(MeatProduct.class, 3L), 2);
		
		em.persist(p1);
		em.persist(p2);

		
		
		/*BORRADO DE all PURCHASEs*/
		List<Purchase> c= (List)c1.getPurchase();
		
		System.out.println(c.get(0).getNumInvoice());
		
		c1.getPurchase().remove(c.get(0));
		
		
	
		em.getTransaction().commit();
		em.close();

	
	}
	
	


	public static void testConsumerPurchaseProducts(){
		/*ESCENARIO  A PARTIR DE UN CONSUMER SE UN PURHCASE*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Consumer c = em .getReference(Consumer.class, 3L);

		Purchase compra1 = new Purchase();
		compra1.setConsumer(c);
		compra1.addProductInPurchaseProduct((MeatProduct)em.getReference(MeatProduct.class, 1L), 1);
		compra1.addProductInPurchaseProduct((MeatProduct)em.getReference(MeatProduct.class, 4L), 1);
		
	
		em.persist(compra1);
	
		em.getTransaction().commit();
		em.close();
	

	}	








	/*************************************************************************************************/	
	/*INICIO DE LAS PRUEBAS PARA TRADER*/	
	/*************************************************************************************************/	




	public static void testAddressTreader(){
		/* Create EntityManagerFactory hace uso del archivo persistence.xml en src/main/resources/meta-inf*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager(); 


		Trader t = em.getReference(Trader.class, 1L);
		em.getTransaction().begin();

		List<Address> ads = new ArrayList<Address>();
		ads.add(new Address("Calle 24",1,2));
		ads.add(new Address("Calle 26",1,3));
		ads.add(new Address("Calle 26",1,4));

		t.setAddress(ads);

		System.out.println(t);

		t.removeAddress(t.getAddress().get(2));
		System.out.println(t);		


		em.getTransaction().commit();
		em.close();

	}


	public static void testStockTraderProducts(){
		/****
		 * UN TRADER SOLO TIENE UN STOCK
		 * **/
		/* Create EntityManagerFactory hace uso del archivo persistence.xml en src/main/resources/meta-inf*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");


		/* Create EntityManager habre la transaccion  hace comit y cierra*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();



		/*ESCENARIO 1 DONDE UN TRADER TIENE UN STOCKY SE AGREGARN PRODUCTOS*/
		Trader trader = em.getReference(Trader.class, 1L);

		//trae los productos
		MeatProduct p1 = em.getReference(MeatProduct.class, 1L);
		MeatProduct p2 = em.getReference(MeatProduct.class, 2L);
		MeatProduct p3 = em.getReference(MeatProduct.class, 3L);
		MilkProduct p5 = em.getReference(MilkProduct.class, 7L);
		MilkProduct p6 = em.getReference(MilkProduct.class, 6L);


		Stock stock = new  Stock();
		stock.setDateStock(new Date());
		stock.setTrader(trader);
		stock.getProducts().add(new StockProducts(stock, p1, 300));
		stock.getProducts().add(new StockProducts(stock, p2, 40));
		stock.getProducts().add(new StockProducts(stock, p3, 50));
		stock.getProducts().add(new StockProducts(stock, p5, 20));
		stock.getProducts().add(new StockProducts(stock, p6, 10));

		em.persist(stock);
		em.getTransaction().commit();
		em.close();
		//c = em.find(Consumer.class, new Long(2));
		//System.out.println("consulta Employee :- " + c );

	}



	public static void testTraderStockProduct(){
		/* Create EntityManagerFactory hace uso del archivo persistence.xml en src/main/resources/meta-inf*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");

		/* Create EntityManager habre la transaccion  hace comit y cierra*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();


		/*CON TRADER CONOCIDO*/
		Trader t = em.getReference(Trader.class, 2L);

		MeatProduct p4 = em.getReference(MeatProduct.class, 5L);
		MilkProduct p5 = em.getReference(MilkProduct.class, 7L);
		MilkProduct p6 = em.getReference(MilkProduct.class, 2L);


		Stock stock = new  Stock();
		stock.setDateStock(new Date());
		stock.setTrader(t);
		stock.getProducts().add(new StockProducts(stock, p4, 300));
		stock.getProducts().add(new StockProducts(stock, p5, 40));
		stock.getProducts().add(new StockProducts(stock, p6, 50));

		em.persist(stock);
		em.getTransaction().commit();
		em.close();

	}



	public static void testAddProductsStock(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");

		/*A PARTIR DE UN STOCK EN UN TRADER SE ADICIONA UN PRODUCTO*/

		/* Create EntityManager habre la transaccion  hace comit y cierra*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		/*CON TRADER CONOCIDO*/
		Trader t = em.getReference(Trader.class, 2L);
		long idStock = (long)t.getStock().getId();

		Stock stock = em.getReference(Stock.class, idStock);
		stock.setTrader(t);
		stock.addProduct(em.getReference(MeatProduct.class, 4L), 2);

		em.persist(stock);
		em.getTransaction().commit();
		em.close();

	}


	public static void testDeleteProductsStock(){

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");

		/*A PARTIR DE UN STOCK EN UN TRADER SE ADICIONA UN PRODUCTO*/

		/* Create EntityManager habre la transaccion  hace comit y cierra*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		/*CON TRADER CONOCIDO*/
		Trader t = em.getReference(Trader.class, 2L);
		long idStock = (long)t.getStock().getId();

		Stock stock = em.getReference(Stock.class, idStock);
		List<StockProducts> stp = (List)stock.getProducts();

		System.out.println(stp);

		stock.getProducts().remove(stp.get(0));

		System.out.println(stp);

		em.getTransaction().commit();
		em.close();

	}



	public static void testUdateProductsStock(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		/* Create EntityManager habre la transaccion  hace comit y cierra*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		/*CON TRADER CONOCIDO*/
		Trader t = em.getReference(Trader.class, 2L);
		long idStock = (long)t.getStock().getId();

		Stock stock = em.getReference(Stock.class, idStock);

		List<StockProducts> stp = (List)stock.getProducts();
		System.out.println(stp);
		stp.get(0).setQuantity(2000);
		System.out.println(stp);

		em.getTransaction().commit();
		em.close();

	}






	public static void testTraderInvoice(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		/* Create EntityManager habre la transaccion  hace comit y cierra*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Trader td = em.getReference(Trader.class, 2L);
		Invoice inv1 = new Invoice();
		inv1.setDateInvoice(new Date());
		inv1.setTrader(td);
		td.addInvoice(inv1);

		em.persist(inv1);


		Invoice inv2 = new Invoice();
		inv2.setDateInvoice(new Date());
		inv2.setTrader(td);
		td.addInvoice(inv2);


		em.persist(inv2);		

		em.getTransaction().commit();
		em.close();
	}







	public static void testTraderInvoiceProducts(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		/*get invoice de un trader*/

		Trader td = em.getReference(Trader.class, 1L);
		Invoice in = new Invoice();
		in.setTrader(td);
		in.addInvoiceProduct((MeatProduct)em.getReference(MeatProduct.class, 1L), 5);
		in.addInvoiceProduct((MeatProduct)em.getReference(MeatProduct.class, 2L), 5);
		in.addInvoiceProduct((MeatProduct)em.getReference(MeatProduct.class, 4L), 5);
		in.addInvoiceProduct((MilkProduct)em.getReference(MilkProduct.class, 6L), 5);

		em.persist(in);		


		Invoice in2 = new Invoice();
		in2.setTrader(td);
		in2.addInvoiceProduct((CareProduct)em.getReference(CareProduct.class, 8L), 1);
		in2.addInvoiceProduct((CareProduct)em.getReference(CareProduct.class, 9L), 1);
		in2.addInvoiceProduct((MilkProduct)em.getReference(MilkProduct.class, 6L), 3);

		em.persist(in2);		

		em.getTransaction().commit();
		em.close();
	}









}//fin clase
