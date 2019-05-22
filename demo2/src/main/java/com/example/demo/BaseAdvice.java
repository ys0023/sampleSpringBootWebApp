package com.example.demo;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.common.util.CommonUtil;

/**
 * AOPクラス.
 */
@Aspect
@Component
public class BaseAdvice {

	/** Logger. */
	private static Log LOG = LogFactory.getLog(BaseAdvice.class);

	/**
	 * メソッド事前処理.
	 * <p>
	 * Beforeアノテーションで指定している対象（今回はcontrollerクラス）のメソッドの実行前に実行されます.<br>
	 * 対象クラス、メソッド名とパラメータをログ出力します.
	 * </p>
	 * @param joinPoint JoinPoint
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	@Before("execution(* com.example.demo.controller.*.*(..))")
	public void invokeApiControllerBefore(JoinPoint joinPoint) throws IllegalArgumentException, IllegalAccessException {
		
		LOG.info("start : " + joinPoint.getTarget().getClass().toString() + ", " + joinPoint.getSignature().getName());
		
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)attributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        
        StringBuilder sb = new StringBuilder();
        
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
          String name = names.nextElement();
          String value =  request.getParameter(name);
          
          sb.append(name + " : " + value);
          sb.append(", ");
        }
        
        String paramStr = null;
        // 最後の","を除去する
        if (1 < sb.length()) {
        	paramStr = CommonUtil.removeLastChar(sb.toString());        	
        }
		
		LOG.info("param : [" + paramStr + "]");
	}

	/**
	 * メソッド事後処理.
	 * <p>
	 * Beforeアノテーションで指定している対象（今回はcontrollerクラス）のメソッドの実行後に実行されます.<br>
	  * 対象クラス、メソッド名をログ出力します.<br>
	  * 注）メソッドが正常終了の場合のみ実行されます（Exception発生時は実行されません）
	  * 
	 * </p>
	 * @param joinPoint JoinPoint
	 * @param returnValue Object
	 */
	@AfterReturning(pointcut = "execution(* com.example.demo.controller.*.*(..))", returning= "returnValue")
	public void invokeControllerAfter(JoinPoint joinPoint, Object returnValue) {
		
		LOG.info("end : "  + joinPoint.getTarget().getClass().toString() + ", " + joinPoint.getSignature().getName());
	}

	/**
	 * 例外事後処理.
	 * <p>
	 * Beforeアノテーションで指定している対象（今回はcontrollerクラス）のメソッドの例外発生後に実行されます.<br>
	  * 対象クラス、メソッド名と例外内容をログ出力します.
	 * </p>
	 * @param joinPoint JoinPoint
	 * @param e Throwable
	 */
	@AfterThrowing(value = "execution(* com.example.demo.controller.*.*(..))", throwing = "e")
	public void invokeControllerAfterThrowing(JoinPoint joinPoint, Throwable e) {
		
		LOG.error("exception end : "  + joinPoint.getTarget().getClass().toString() + ", " + joinPoint.getSignature().getName());
		LOG.error(e.toString());
	}

}
