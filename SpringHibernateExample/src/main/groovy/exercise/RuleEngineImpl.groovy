package exercise


import java.awt.GraphicsConfiguration.DefaultBufferCapabilities;

import org.springframework.stereotype.Component;;

@Component
class RuleEngineImpl implements RuleEngine {

	@Override
	public void run(Rule rule, Object object) {
		// TODO Auto-generated method stub
		println "Execute rule"

		def exit = false
		rule.parameters.each{ArrayList params->
			def paramindex = 0
			def success = true

			if (!exit) {
				rule.conditions.each {

					println  "Condition Param index:"+paramindex
					success =success && it(object,params[paramindex])
					println "condition success:"+success
					paramindex++
				}

				if(success && !exit){
					rule.actions.each{
						println "Action Param index: " + paramindex
						it(object,params[paramindex])
						paramindex++
					}
					if (rule.singlehit){
						exit=true
					}
				}
			}


		}



	}
}
