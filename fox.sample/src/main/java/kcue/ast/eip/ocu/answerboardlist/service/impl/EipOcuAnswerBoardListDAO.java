package kcue.ast.eip.ocu.answerboardlist.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kcue.ast.eip.ocu.answerboardlist.service.EipOcuAnswerBoardListVO;
import kcue.ast.eip.ocu.answerboardlist.service.JogunVO;
import kcue.common.service.KcueAbstractDAO;

@Repository("EipOcuAnswerBoardListDAO")
public class EipOcuAnswerBoardListDAO extends KcueAbstractDAO{

	/**
	 * 답변게시판의 모든글 가져오기.
	 * @param JogunVO - 조회조건의 정보가 담긴 JogunVO
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EipOcuAnswerBoardListVO> selectAnswerBoardList(Map<String,Object> mp){
		System.out.println("selectAnswerBoardList실행----------------------------------------------");
		return (List<EipOcuAnswerBoardListVO>)list("EipOcuAnswerBoardListDAO.selectAnswerBoardList",mp);
	}
	/**
	 * 공지사항의 조회조건인 분류 내용을 조회한다.
	 * @param JogunVO - 조회조건의 정보가 담긴 JogunVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("unchecked")
	public List<JogunVO> selectinquiryConditions(JogunVO vo){
    	System.out.println("selectinquiryConditions실행----------------------------------------------");
    	return (List<JogunVO>)list("EipOcuAnswerBoardListDAO.selectinquiryConditions",vo);
    }
	/**
	 * 글의 개수를 가져온다.
	 * @return int
	 * @exception Exception
	 */
    public int getboardCount() {
    	System.out.println("getboardCount실행--------------------------------------------------------");
    	return (int) selectByPk("EipOcuAnswerBoardListDAO.getboardCount","");
    }
    
    
}
