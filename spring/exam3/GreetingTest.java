package exam3;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext factory=
				new ClassPathXmlApplicationContext("exam1/greetingBean.xml");
		LocalDateTime local=(LocalDateTime)factory.getBean("timeBean");
		
		int hour = local.getHour();
		//인터페이스이름으로 접근시 더 좋음
		/*
		 * Greeting greeting; if()
		 * greeting=((Greeting)factory.getBean("morningGreetingImpl")) ...
		 * .....
		 * greeting.greet();
		 */
		
		if(hour>=6 && hour<12)
			((MorningGreetingImpl)factory.getBean("morningBean")).greet();
		else if(hour >= 12 && hour < 17)
			((AfternoonGreetingImpl)factory.getBean("afternoonbean")).greet();
		else if(hour >= 17 && hour < 22)
			((EveningGreetingImpl)factory.getBean("eveningbean")).greet();
		else((NightGreetingImpl)factory.getBean("nightbean")).greet();
		
		((ClassPathXmlApplicationContext)factory).close();
	}

}
