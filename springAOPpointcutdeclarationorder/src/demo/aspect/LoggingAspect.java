package demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import demo.Account;

@Aspect
@Component
public class LoggingAspect {

	@Before("demo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccount(JoinPoint joinpoint) {
		System.out.println("\n =====>>> Executing @Before advice on addAccount");

		MethodSignature methodsignature = (MethodSignature) joinpoint.getSignature();

		System.out.println("Method: " + methodsignature);

		Object[] args = joinpoint.getArgs();

		for (Object arg : args) {
			System.out.println(arg);
			if (arg instanceof Account) {
				Account account = (Account) arg;

				System.out.println("account name: " + account.getName());
				System.out.println("account name: " + account.getLevel());
			}
		}

	}
}
