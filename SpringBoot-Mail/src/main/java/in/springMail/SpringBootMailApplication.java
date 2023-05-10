package in.springMail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.springMail.service.IPurchaseOrder;

@SpringBootApplication
public class SpringBootMailApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootMailApplication.class, args);
		IPurchaseOrder order = context.getBean(IPurchaseOrder.class);
		try {
			String msg = order.purchase(new String[] { "fossil ", "t-shirt", "shoes" },
					new double[] { 2345.98, 5647.09, 897.09 }, new String[] { "aaaa@gmail.com",
							"bbbb@gmail.com", "ccccc@gmail.com" });
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) context).close();
	}

}
