package exercise;

import org.joda.time.format.DateTimeFormat;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RuleEngineTest {
	public static void main(String[] args) {
		//System.out.println(RuleEngineTest.class.getClassLoader().getResource("RuleEngineTest.java").getPath());
		System.out.println(RuleEngineTest.class.getClassLoader().getResource("").getPath());
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		//ctx.load("classpath:aaa/app-content1.xml");
		ctx.load("classpath:app-content.xml");
		ctx.refresh();
		ContactService contactService = ctx.getBean("contactService", ContactService.class);
		Contact contact = new Contact();
		contact.setId(1l);
		contact.setFirstName("Chris");
		contact.setLastName("Schaefer");
		contact.setBirthDate(DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("1981-05-03"));
		contactService.applyRule(contact);
		System.out.println("Contact: " + contact);
		try {
			System.in.read();
		} catch (Exception ex) {
			ex.printStackTrace();
	}
		contactService.applyRule(contact);
		System.out.println("Contact: " + contact);
	}
}
