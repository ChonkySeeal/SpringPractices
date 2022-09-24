package demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import demo.Account;

@Aspect
@Component
public class LoggingAspect {

	@After("execution(* demo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccount(JoinPoint joinpoint) {
		String method = joinpoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
	}

	@AfterThrowing(pointcut = "execution(* demo.dao.AccountDAO.findAccounts(..))", throwing = "e")
	public void afterThrowingAccountsAdvice(JoinPoint joinpoint, Throwable e) {
		String method = joinpoint.getSignature().toShortString();
		System.out.println("\n ====>>> Executing @AfterThrowing on method: " + method);

		System.out.println("\n ===>>> The exception is: " + e);
	}

	@AfterReturning(pointcut = "execution(* demo.dao.AccountDAO.findAccounts(..))", returning = "accounts")
	public void afterReturningFindAccountsAdvice(JoinPoint joinpoint, List<Account> accounts) {
		String method = joinpoint.getSignature().toShortString();

		System.out.println("\n =====>>> Executing @AfterReturning on method : " + method);

		System.out.println("\n ====>>> result is : " + accounts);

		convertoUpperCase(accounts);

		System.out.println("\n ===>>> modiefied result is : " + accounts);

	}

	private void convertoUpperCase(List<Account> list) {
		for (Account temp : list) {
			String tempstr = temp.getName().toUpperCase();
			temp.setName(tempstr);

		}
	}

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
