/*
 * 표준공통원서 관리시스템
 * 
 * 한국대학교육협의회
 * 폭스소프트 개발팀
 */
package kcue.common.service;

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
public interface KcueAbstractService{

	/*
	 * check box 관련해서 처리해야 함.
	 */
	public void insert4ArrayModel(Object arrayModel, Object model, Object dao) throws Exception;
	
	public void delete4CheckBoxes(Object model, Object dao, String idSetName) throws Exception;
}
