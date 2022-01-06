package kcue.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class KcueSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
	
		//ex.printStackTrace();
		String errMsg = ex.getMessage();
		if(errMsg == null){
			errMsg = "";
		}
		logger.error(request.getRequestURI()+" : doResolveException exception "+errMsg);
		return super.doResolveException(request, response, handler, ex);
	}
	
	

}

