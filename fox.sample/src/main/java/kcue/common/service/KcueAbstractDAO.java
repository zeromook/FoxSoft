/*
 * 대학입학정보포털 사이트
 * 
 * 한국대학교육협의회
 * 폭스소프트 개발팀
 */
package kcue.common.service;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/**  
 * @Class Name : KcueAbstractDAO.java
 * @Description : KcueAbstractDAO Class
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
public abstract class KcueAbstractDAO extends EgovAbstractMapper {

	@Resource(name = "sqlSession")
    public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
    	super.setSqlSessionFactory(sqlSession);
    }
	
}
