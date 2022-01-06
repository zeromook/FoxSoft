/*
 * Copyright 2014 MOSPA(Ministry of Security and Public Administration).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.com.cmm.annotation;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import egovframework.rte.ptl.mvc.bind.annotation.CommandMap;
import egovframework.rte.ptl.mvc.bind.annotation.EgovRequestMappingHandlerAdapter;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;




/**
 * AnnotationCommandMapArgumentResolver.java
 * <p><b>NOTE:</b> <pre> Spring3.1부터 AnnotationMethodHandlerAdapter은 deprecated되었으며 대신, RequestMappingHandlerAdapter를 사용해야한다. 
 * RequestMappingHandlerAdapter에서 ArgumentResolver는 webArgumentResolver가 아닌 HandlerMethodArgumentResolver를 구현해야한다. 
 * ( 클래스의 동작은 기존 CommandMapArgumentResolver와 동일 )
 *   
 * Controller에서 화면(JSP) 입력값을 받기 위해서 일반적으로 Command(Form Class) 객체를 사용하지만, Map 객체를 사용하는걸 선호할 수 있다.
 * Sping MVC는 Controller의 argument를 분석하여 argument값을 customizing 할 수 있는 WebArgumentResolver라는 interface를 제공한다.
 * CommandMapArgumentResolver는 WebArgumentResolver의 구현 클래스이다.
 * CommandMapArgumentResolver는 Controller 메소드의 argument중에 commandMap이라는 Map 객체가 있다면
 * HTTP request 객체에 있는 파라미터이름과 값을 commandMap에 담는다.</b>
 *                </pre>
 * @author 송광호
 * @since 2015.02.04
 * @version 3.0
 * @see CommandMap, {@link EgovRequestMappingHandlerAdapter}
 * @see VO[], {@link EgovRequestMappingHandlerAdapter}
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2015.02.04  송광호            최초 생성
 *
 * </pre>
 */
public class CommandArrayArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		
		
		if((Map.class.isAssignableFrom(parameter.getParameterType())
				&& parameter.hasParameterAnnotation(CommandMap.class)) 
		   //||CmnAthrMenuVO[].class.isAssignableFrom(parameter.getParameterType())){
		   ||parameter.getParameterType().isArray()){
			
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		
		if(Map.class.isAssignableFrom(parameter.getParameterType()) && parameter.hasParameterAnnotation(CommandMap.class))
		{
			Map<String, Object> commandMap = new HashMap<String, Object>();
			HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();			
			Enumeration<?> enumeration = request.getParameterNames();
			
			while(enumeration.hasMoreElements()){
				String key = (String) enumeration.nextElement();
				String[] values = request.getParameterValues(key);
				if(values!=null){
					commandMap.put(key, (values.length > 1) ? values:values[0] );
				}
			}
			
			return commandMap;
			
		//}else if(Array.class.isAssignableFrom(parameter.getParameterType()))
		//}else if(CmnAthrMenuVO[].class.isAssignableFrom(parameter.getParameterType()))
		}else if(parameter.getParameterType().isArray())
		{
			Class<?> clazz = parameter.getParameterType();
			
			//logger.debug("Parameter Class : " + clazz.getCanonicalName());
			
			if (clazz.isArray()) { // ①
			    Class<?> targetClazz = clazz.getComponentType();	// 대상 VO
			    
			    //logger.debug("Target object in array : " + targetClazz.getCanonicalName());
			    
			    HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
			    // ② VO의 property Name 얻기..
			    String[] properties = getPropertyName(targetClazz);
			    
			    // ③ parameter 배열 최대 구하기..
			    int max = 0;
			    for (String getter : properties) {
			    	//logger.debug("Property : " + getter);
					if (request.getParameterValues(getter) == null) {
					    continue;
					}
					
					//logger.debug("ParameterValues's length : " + request.getParameterValues(getter).length);
					if (max < request.getParameterValues(getter).length) {
					    max = request.getParameterValues(getter).length;
					}
			    }
			    
			    //logger.debug("Parameter array's MAX length : " + max);
			    
			    // ④ 리턴할 객체 배열 생성하기..
			    Object ret = Array.newInstance(targetClazz, max);
			    Object target = null;
			    for (int index = 0; index < max; index++) {	// index
				target = targetClazz.newInstance();
				
				for (String property : properties) {
				    String[] values = request.getParameterValues(property);
				    
				    if (values != null && index < values.length) {
					callSetter(target, property, values[index]); // ⑤
				    }
				}
				// ⑥ 배열에 각 파라미터 객체를 지정..
				Array.set(ret, index, target);	
			    }
			    
			    return ret;
			}
		}
		
		return new Object();
	}
	
    /**
     * Setter를 통해 객체에 대한 property name list를 얻음.
     * 
     * @param clazz
     * @return
     */
    protected String[] getPropertyName(Class<?> clazz) {
	List<String> list = new ArrayList<String>();
	
	Method[] methods = clazz.getMethods();
	
	for (Method method : methods) {
	    if (method.getName().startsWith("set") && method.getParameterTypes().length == 1) {
		list.add(method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4));
	    }
	}
	
	return list.toArray(new String[0]);
    }
    
    /**
     * Property의 setter를 호출함.
     * 
     * @param vo
     * @param propertyName
     * @param value
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    protected void callSetter(Object vo, String propertyName, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
	PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(vo.getClass(), propertyName);
	
	pd.getWriteMethod().invoke(vo, new Object[] {value});
	
    }


}
