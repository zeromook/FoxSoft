package kcue.ast.eip.ocu.answerboardlist.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kcue.ast.eip.ocu.answerboardlist.service.EipOcuAnswerBoardListService;
import kcue.ast.eip.ocu.answerboardlist.service.EipOcuAnswerBoardListVO;
import kcue.ast.eip.ocu.answerboardlist.service.JogunVO;

@Service("EipOcuAnswerBoardListService")
public class EipOcuAnswerBoardListServiceImpl implements EipOcuAnswerBoardListService  {

    /*EipOcuAnswerBoardListDAO*/
	@Resource(name = "EipOcuAnswerBoardListDAO")
    protected EipOcuAnswerBoardListDAO eipOcuAnswerBoardListDAO;
	
	/**
	 * 답변게시판의 모든 글을 가져온다.
	 * @param EipOcuAnswerBoardListVO - 조회조건의 정보가 담긴 EipOcuAnswerBoardListVO
	 * @return List
	 * @exception Exception
	 */
	@Override
	public List<EipOcuAnswerBoardListVO> selectAnswerBoardList(Map<String,Object> mp) {
		return eipOcuAnswerBoardListDAO.selectAnswerBoardList(mp);
	}
	/**
	 * 공지사항의 조회조건인 분류 내용을 조회한다.
	 * @param JogunVO - 조회조건의 정보가 담긴 JogunVO
	 * @return List
	 * @exception Exception
	 */
    @Override
    public List<JogunVO> selectinquiryConditions(JogunVO vo) {
    	System.out.println("Service들어옴-----------------------");
        return eipOcuAnswerBoardListDAO.selectinquiryConditions(vo);
    }

	/**
	 * 총 글의 개수를 가져온다.
	 * @return int
	 * @exception Exception
	 */
    @Override
    public int getboardCount() {
        return eipOcuAnswerBoardListDAO.getboardCount();
	}


}
