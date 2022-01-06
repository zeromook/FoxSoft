package kcue.common.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Component
@Aspect
public class KcueMethodInvokeAspect {
	
    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controllerBean() {}

    @Pointcut("execution(* kcue..*.*(..)) or execution(* egovframework..*.*(..))")
    public void methodPointcut() {}
    
	//private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Around("methodPointcut()")
	public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object retVal = joinPoint.proceed();
		stopWatch.stop();
		StringBuffer logMessage = new StringBuffer();
		logMessage.append(joinPoint.getTarget().getClass().getName());
		logMessage.append(".");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append("(");
		logMessage.append(")");
		logMessage.append(" execution time: ");
		logMessage.append(stopWatch.getTotalTimeMillis());
		logMessage.append(" ms");
		//if(log.isInfoEnabled()) log.info(logMessage.toString());
		return retVal;
	}
}