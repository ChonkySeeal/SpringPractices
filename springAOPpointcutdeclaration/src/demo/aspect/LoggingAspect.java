package demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* demo.dao.*.*(..))")
	public void doPointcut() {
	}

	@Before("doPointcut()")
	public void beforeAddAccount() {
		System.out.println("\n =====>>> Executing @Before advice on addAccount");
	}
}
