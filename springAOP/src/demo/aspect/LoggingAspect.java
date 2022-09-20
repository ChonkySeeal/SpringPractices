package demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(public boolean addAccount())")
	public void beforeAddAccount() {
		System.out.println("\n =====>>> Executing @Before advice on addAccount");
	}
}
