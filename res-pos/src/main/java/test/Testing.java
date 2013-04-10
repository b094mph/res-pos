package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.res.dao.hibernate.AddressDao;
import com.res.model.Address;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("WebContent/WEB-INF/dispatcher-servlet.xml");

		AddressDao addressDao = (AddressDao) ctx.getBean("addressDao");
		
		Address address = new Address();
		address.setStreet1("123 Main Street");
		address.setCity("Havertown");
		addressDao.save(address);
		System.out.println("save completed.");
	}

}
