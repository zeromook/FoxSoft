package kcue.ast.eip.ocu.answerboardlist.service;

import java.util.List;
import java.util.Map;

public interface EipOcuAnswerBoardListService {
	
	/**
	 * 게시판의 모든글을 가져온다.
	 * @param EipOcuAnswerBoardListVO - 모든 글의 정보가 담긴 EipOcuAnswerBoardListVO
	 * @return List
	 * @exception Exception
	 */
	public List<EipOcuAnswerBoardListVO> selectAnswerBoardList(Map<String,Object> mp);
	
	/**
	 * 게시판의 조회조건을 가져온다.
	 * @param JogunVO - 조회조건의 정보가 담긴 JogunVO
	 * @return List
	 * @exception Exception
	 */
	public List<JogunVO> selectinquiryConditions(JogunVO vo);
	
	/**
	 * 총 글의 개수를 가져온다.
	 * @return int
	 * @exception Exception
	 */
	public int getboardCount();
	
}
