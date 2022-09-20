package demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import demo.Account;

@Aspect
@Component
public class LoggingAspect {

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
