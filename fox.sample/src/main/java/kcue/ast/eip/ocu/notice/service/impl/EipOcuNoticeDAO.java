package kcue.ast.eip.ocu.notice.service.impl;

import java.util.List;

import kcue.ast.eip.ocu.notice.service.EipOcuNoticeVO;
import kcue.common.service.KcueAbstractDAO;

import org.springframework.stereotype.Repository;

/**
 * @Class Name : EipOcuNoticeDAO.java
 * @Description : EipOcuNoticeDAO class
 * @Modification Information
 *
 * @author 장근석
 * @since 2015.08.05
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("EipOcuNoticeDAO")
public class EipOcuNoticeDAO extends KcueAbstractDAO {

	/**
	 * 공지사항의 조회조건인 분류 내용을 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return List
	 * @exception Exception
	 */
	public List<EipOcuNoticeVO> selectOcuNoticeInquireCndList(EipOcuNoticeVO searchCodeVO){
		return (List<EipOcuNoticeVO>)list("EipOcuNoticeDAO.selectOcuNoticeInquireCndList", searchCodeVO);
	}

	/**
	 * 공지사항의 목록 내용을 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return List
	 * @exception Exception
	 */
	public List<EipOcuNoticeVO> selectOcuNoticeList(EipOcuNoticeVO searchVO){
		return (List<EipOcuNoticeVO>)list("EipOcuNoticeDAO.selectOcuNoticeList", searchVO);
	}
	
	/**
	 * 공지사항의 페이징처리를 위한 전체 게시글건수를 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return int
	 * @exception Exception
	 */
	public int selectOcuNoticeToCnt(EipOcuNoticeVO searchVO) {
		return (Integer)selectByPk("EipOcuNoticeDAO.selectOcuNoticeToCnt", searchVO);
	}
	
	/**
	 * 공지사항의 페이징처리를 위한 전체 게시글건수를 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return int
	 * @exception Exception
	 */
	public int selectOcuNoticeToCntOrg(EipOcuNoticeVO searchVO) {
		return (Integer)selectByPk("EipOcuNoticeDAO.selectOcuNoticeToCntOrg", searchVO);
	}

	/**
	 * 공지사항의 게시글 상세내용을 조회한다.
	 * @param int - 공지사항 상담글 일련번호
	 * @return EipOcuNoticeVO
	 * @exception Exception
	 */
	public EipOcuNoticeVO selectOcuNoticeView(int sn) {
		return (EipOcuNoticeVO)selectByPk("EipOcuNoticeDAO.selectOcuNoticeView", sn);
	}
	
    /**
	 * EipUnventNews 이전글 다음을 목록
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 이전글 다음글 목록
	 * @exception Exception
	 */
	public EipOcuNoticeVO selectOcuNoticePreView(EipOcuNoticeVO searchVO) {
		// TODO Auto-generated method stub
		return (EipOcuNoticeVO) selectByPk("EipOcuNoticeDAO.selectOcuNoticePreView", searchVO);
	}

	/**
	 * 공지사항의 게시글 상세내용 조회시 조회수 업데이트
	 * @param int - 업데이트할 게시 일련번호
	 * @return void
	 * @exception Exception
	 */
	public void updateOcuNoticeInqireCo(int sn) {
		update("EipOcuNoticeDAO.updateOcuNoticeInqireCo", sn);
	}

    /**
	 * 공지사항 첨부파일 조회
	 * @param sn - 게시물 번호
	 * @return 첨부파일 목록
	 * @exception Exception
	 */
	public List<EipOcuNoticeVO> selectFileList(int sn) {
		// TODO Auto-generated method stub
		return (List<EipOcuNoticeVO>)list("EipOcuNoticeDAO.selectFileList", sn);
	}
	
	/**
	 * 페이지 사이즈 목록을 불러온다.
	 * @param searchCodeVO - 조회할 정보가 담긴 VO
	 * @return 페이지 사이즈 목록
	 * @exception Exception
	 */
    
	public List<EipOcuNoticeVO> selectPageSizeList(EipOcuNoticeVO searchCodeVO){
        return (List<EipOcuNoticeVO>)list("EipOcuNoticeDAO.selectPageSizeList", searchCodeVO);
    }
	
	
}