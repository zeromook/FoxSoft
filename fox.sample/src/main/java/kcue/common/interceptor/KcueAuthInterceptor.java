package kcue.common.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kcue.common.util.StringUtil;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import egovframework.rte.fdl.property.EgovPropertyService;


public class KcueAuthInterceptor extends HandlerInterceptorAdapter {
	/** log 처리 서비스 */
	private static final Logger log = Logger.getLogger("KcueAuthInterceptor");
	
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    /** MessageSourceService */
	@Resource(name="messageSource")
	private MessageSource messageSource;  
	
	/**
     * Controller의 메소드가 수행이 완료되고, View 를 호출하기 전에 호출됩니다.
     */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		String url = request.getRequestURI().toString();
		String menuId = request.getParameter("p_menu_id");

		String servletType = url.substring(url.lastIndexOf("."), url.length());
		String link = request.getParameter("link");
		String pmenu = request.getParameter("p_menu_id");
	}
	
	/**
     * View 작업까지 완료된 후 Client에 응답하기 바로 전에 호출됩니다.
     */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		String url = request.getRequestURI().toString();
		String menuId = StringUtil.nchk(request.getParameter("p_menu_id"),"");
		String agent = StringUtil.nchk(request.getHeader("User-Agent"),"");
		String servletType = url.substring(url.lastIndexOf("."), url.length());
	}
	
	/**
     * Controller 가 수행되기 전에 호출됩니다.
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)   {
		
		boolean isCheck = true;	// 등록된 정보와 접속 정보가 일치하는지 체크(menuid, url 및 권한)
		/*
		// python-urllib를 이용한 웹 크롤링 차단
		String agent = StringUtil.nchk(request.getHeader("User-Agent"),"");
		if(agent.toLowerCase().indexOf("python-urllib") > -1){
			try{
				response.sendRedirect("/EipEtcAccesAuthPgeView.jsp");
			} catch(IOException ioe){
				log.error(messageSource.getMessage("fail.common.msg", null, Locale.KOREA));
			}
		}
		*/
		
		HttpSession session = request.getSession(false);
		String menuId = request.getParameter("p_menu_id");
		
		if(menuId == null) menuId = "";
		
		String url = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (url == null) {
			url = request.getRequestURI();
		}
		String servletType = url.substring(url.lastIndexOf("."), url.length());
		String link = request.getParameter("link");
		
		return isCheck;
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
