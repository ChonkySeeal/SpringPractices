package spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* spring.controller.*.*(..))")
	private void ControllerPointcut() {
	};

	@Pointcut("execution(* spring.service.*.*(..))")
	private void ServicePointcut() {
	};

	@Pointcut("execution(* spring.dao.*.*(..))")
	private void DAOPointcut() {
	};

	@Pointcut("ControllerPointcut() || ServicePointcut() || DAOPointcut()")
	private void forAppFlow() {
	};

	@Before("forAppFlow()")
	public void before(JoinPoint joinpoint) {
		String method = joinpoint.getSignature().toShortString();
		logger.info("===>>> in @Before: method: " + method);

		Object[] args = joinpoint.getArgs();

		for (Object arg : args) {
			logger.info("===>>> argument: " + arg);
		}
	}

	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info("=====>> in @AfterReturning: from method: " + theMethod);

		// display data returned
		logger.info("=====>> result: " + theResult);

	}

}
