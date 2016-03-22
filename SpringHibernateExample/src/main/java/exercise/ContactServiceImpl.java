package exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import exercise.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
	@Autowired
	ApplicationContext ctx;
	@Autowired
	private RuleFactory ruleFactory;
	@Autowired
	private RuleEngine ruleEngine;

	public void applyRule(Contact contact) {
		Rule ageCategoryRule = ruleFactory.getAgeCategoryRule();
		ruleEngine.run(ageCategoryRule, contact);
	}
}
