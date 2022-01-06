/*
 * 표준공통원서 관리시스템
 * 
 * 한국대학교육협의회
 * 폭스소프트 개발팀
 */
package kcue.common.service;

import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**  
 * @Class Name : KcueAbstractServiceImpl.java
 * @Description : KcueAbstractService ServiceImpl Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2012.06.14           최초생성
 * 
 * @author 폭스소프트 개발팀
 * @since 2012.06.14
 * @version 1.0
 * @see
 */
@Service("KcueAbstractService")
public abstract class KcueAbstractServiceImpl extends EgovAbstractServiceImpl implements KcueAbstractService{
	/*
	 * check box 관련해서 처리해야 함.
	 */
	@SuppressWarnings("boxing")
	public void insert4ArrayModel(Object arrayModel, Object model, Object dao) throws Exception {
		Class<? extends Object> arrayModelClass = arrayModel.getClass();
		Class<? extends Object> modelClass = null;
		Class<? extends Object> daoClass = null;

		Method[] arrayModelMethods = arrayModelClass.getMethods();
		Method modelMethod;
		Method daoMethod;
		
		String arrayGetMethodName = "";
		String setMethodName = "";
		Object object;
		int arrayLength = 0;
		String arrayMethodName = "";

		for(Method arrayMethod : arrayModelMethods) {
			arrayMethodName = arrayMethod.getName(); 
			if(arrayMethodName.startsWith("get")) {
				object = arrayMethod.invoke(arrayModel, (Object[])null);
				if (object != null) {
					if(object instanceof String[]) {
						String[] properties = (String[]) object;
						arrayLength = properties.length;
					} else if(object instanceof int[]) {
						int[] properties = (int[]) object;
						arrayLength = properties.length;
					} else if(object instanceof double[]) {
						double[] properties = (double[]) object;
						arrayLength = properties.length;
					} else if(object instanceof float[]) {
						float[] properties = (float[]) object;
						arrayLength = properties.length;
					}
					break;
				}
			}
		}
		
		for(int i = 0; i < arrayLength; i++) {
			for(Method arrayMethod : arrayModelMethods) {
				arrayGetMethodName = arrayMethod.getName();
				if(arrayGetMethodName.startsWith("get")) {
					object = arrayMethod.invoke(arrayModel, (Object[])null);
					if (object != null) {
						setMethodName = "set" + arrayGetMethodName.substring(3, arrayGetMethodName.length());
						modelClass = model.getClass();
						
						if(object instanceof String[]) {
							String[] properties = (String[]) object;
							modelMethod = modelClass.getMethod(setMethodName, new Class[]{String.class});
							modelMethod.invoke(model, properties[i]);
						} else if(object instanceof int[]) {
							int[] properties = (int[]) object;
							modelMethod = modelClass.getMethod(setMethodName, new Class[]{int.class});
							modelMethod.invoke(model, properties[i]);
						} else if(object instanceof double[]) {
							double[] properties = (double[]) object;
							modelMethod = modelClass.getMethod(setMethodName, new Class[]{double.class});
							modelMethod.invoke(model, properties[i]);
						} else if(object instanceof float[]) {
							float[] properties = (float[]) object;
							modelMethod = modelClass.getMethod(setMethodName, new Class[]{float.class});
							modelMethod.invoke(model, properties[i]);
						}
					}
				}
			}
			
			daoClass = dao.getClass();
			daoMethod = daoClass.getMethod("insert", modelClass);
    		daoMethod.invoke(dao, model);
		}
	}
	
	public void delete4CheckBoxes(Object model, Object dao, String idSetName) throws Exception {
		
		Class<? extends Object> modelClass = model.getClass();
		Method modelMethod = modelClass.getMethod("getCheckBoxes", (Class<?>[])null);

		Class<? extends Object> daoClass = dao.getClass();
		Method daoMethod = daoClass.getMethod("delete", modelClass);

		String[] checkStr = (String[]) modelMethod.invoke(model, (Object[])null);

		if(checkStr != null && checkStr.length > 0) {
    		Method setMethod;
    		for(String id : checkStr) {
    			setMethod = modelClass.getMethod(idSetName, String.class);
    			setMethod.invoke(model, id);
    			
        		daoMethod.invoke(dao, model);
    		}
    	} else {
    		daoMethod.invoke(dao, model);
    	}
	}
}
