
package kcue.ast.eip.ocu.notice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kcue.ast.eip.ocu.notice.service.EipOcuNoticeService;
import kcue.ast.eip.ocu.notice.service.EipOcuNoticeVO;
import kcue.common.service.KcueAbstractServiceImpl;


/**
 * 공지사항 목록 작업을 위한 Service Implements 클래스
 * @author 응용개발 장근석
 * @since 2015.08.05
 * @version 1.0
 * @see
 */

@Service("EipOcuNoticeService")
public class EipOcuNoticeServiceImpl extends KcueAbstractServiceImpl implements EipOcuNoticeService {
	
	/** EipUinfGnrlDAO */
	@Resource(name = "EipOcuNoticeDAO")
	protected EipOcuNoticeDAO eipOcuNoticeDAO;
	

	/**
	 * 공지사항의 조회조건인 분류 내용을 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return List
	 * @exception Exception
	 */
	@Override
	public List<EipOcuNoticeVO> selectOcuNoticeInquireCndList(EipOcuNoticeVO searchCodeVO) {
		return eipOcuNoticeDAO.selectOcuNoticeInquireCndList(searchCodeVO);
	}

	/**
	 * 공지사항의 목록 내용을 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return List
	 * @exception Exception
	 */
	public List<EipOcuNoticeVO> selectOcuNoticeList(EipOcuNoticeVO searchVO) {
		return eipOcuNoticeDAO.selectOcuNoticeList(searchVO);
	}

	/**
	 * 공지사항의 페이징처리를 위한 전체 게시글건수를 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return int
	 * @exception Exception
	 */
	public int selectOcuNoticeToCnt(EipOcuNoticeVO searchVO) {
		return eipOcuNoticeDAO.selectOcuNoticeToCnt(searchVO);
	}
	
	/**
	 * 공지사항의 페이징처리를 위한 전체 게시글건수를 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return int
	 * @exception Exception
	 */
	public int selectOcuNoticeToCntOrg(EipOcuNoticeVO searchVO) {
		return eipOcuNoticeDAO.selectOcuNoticeToCntOrg(searchVO);
	}

	/**
	 * 공지사항의 게시글 상세내용을 조회한다.
	 * @param int - 조회할 게시 일련번호
	 * @return EipOcuNoticeVO
	 * @exception Exception
	 */
	public EipOcuNoticeVO selectOcuNoticeView(int sn) {
		return eipOcuNoticeDAO.selectOcuNoticeView(sn);
	}
	
    /**
	 * EipUnventNews 이전글 다음을 목록
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 이전글 다음글 목록
	 * @exception Exception
	 */
	@Override
	public EipOcuNoticeVO selectOcuNoticePreView(EipOcuNoticeVO searchVO) {
		return eipOcuNoticeDAO.selectOcuNoticePreView(searchVO);
	}

	/**
	 * 공지사항의 게시글 상세내용 조회시 조회수 업데이트
	 * @param int - 조회할 게시 일련번호
	 * @return void
	 * @exception Exception
	 */
	public void updateOcuNoticeInqireCo(int sn) {
		eipOcuNoticeDAO.updateOcuNoticeInqireCo(sn);
	}
	
    /**
	 * EipOcuNotice 첨부파일 조회
	 * @param sn - 게시물 번호
	 * @return 첨부파일 목록
	 * @exception Exception
	 */
	@Override
	public List<EipOcuNoticeVO> selectFileList(int sn) {
		return eipOcuNoticeDAO.selectFileList(sn);
	}
	
	/**
	 * 페이지 사이즈 목록 조회
	 * @param searchVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return List
	 * @exception Exception
	 */
	@Override
	public List<EipOcuNoticeVO> selectPageSizeList(EipOcuNoticeVO searchCodeVO){
		return eipOcuNoticeDAO.selectPageSizeList(searchCodeVO);
	}


}