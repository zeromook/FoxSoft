package kcue.common.interceptor;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class KcueLoggingInterceptor extends HandlerInterceptorAdapter {
	
	/** log 처리 서비스 */
	private static final Logger logger = LoggerFactory
			.getLogger(KcueLoggingInterceptor.class);

	/** MessageSourceService */
	@Resource(name="messageSource")
	private MessageSource messageSource; 
	
	/**
	 * <pre>
	 * 전처리 메시지 처리
	 * Controller 가 수행되기 전에 호출됩니다.
	 * </pre>
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		//if returned false, we need to make sure 'response' is sent
		return true;
	}

//	@Override
//	public void postHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		System.out.println("Request URL::" + request.getRequestURL().toString()
//				+ " Sent to Handler :: Current Time=" + System.currentTimeMillis());
//		//we can add attributes in the modelAndView and use that in the view page
//	}

	/**
	 * <pre>
	 * View 작업까지 완료된 후 Client에 응답하기 바로 전에 호출됩니다.
	 * </pre>
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		
		if(ex != null) {
			logger.error(messageSource.getMessage("fail.common.msg", null, Locale.KOREA));
		}
		
		long startTime = 0L;
		long endTime = 0L;
		boolean timeFlg = false;
		if(request.getAttribute("startTime") != null){
			startTime = (Long) request.getAttribute("startTime");
			endTime = System.currentTimeMillis() - startTime;
			timeFlg = true;
		}
		String uri = (String) request.getAttribute("uri");
	}

	/**
	 * 파라미터 찍기
	 * @param map
	 * @return
	 */
	private String actionParamString(Map<String, ? extends Object> map){

		Set<String> keySet = map.keySet();

		String params = "";
		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String key = iterator.next();

			Object value = map.get(key);
			if(value instanceof String[]){
				String[] valueArr =(String[]) value;
				for (int i = 0; i < valueArr.length; i++) {
					params +=key+":"+valueArr[i]+", ";
				}
			}else {
				params +=key+":"+value+", ";
			}

		}
		return params+"]";
	}


}

