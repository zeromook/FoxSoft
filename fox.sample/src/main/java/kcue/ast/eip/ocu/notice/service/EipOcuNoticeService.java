package kcue.ast.eip.ocu.notice.service;

import java.util.List;

/**
 * 공지사항 목록 작업을 위한 Service 클래스
 * @author 응용개발 장근석
 * @since 2015.08.05
 * @version 1.0
 * @see
 */

public interface EipOcuNoticeService {

	/**
	 * 공지사항의 조회조건인 분류 내용을 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return List
	 * @exception Exception
	 */
	public List<EipOcuNoticeVO> selectOcuNoticeInquireCndList(EipOcuNoticeVO searchCodeVO);

	/**
	 * 공지사항의 목록 내용을 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return List
	 * @exception Exception
	 */
	public List<EipOcuNoticeVO> selectOcuNoticeList(EipOcuNoticeVO searchVO);
	
	/**
	 * 공지사항의 페이징처리를 위한 전체 게시글건수를 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return int
	 * @exception Exception
	 */
	public int selectOcuNoticeToCnt(EipOcuNoticeVO searchVO);

	/**
	 * 공지사항의 전체글 수를 위한 전체 게시글건수를 조회한다.
	 * @param kcueVO - 조회조건의 정보가 담긴 KcueDefaultVO
	 * @return int
	 * @exception Exception
	 */
	public int selectOcuNoticeToCntOrg(EipOcuNoticeVO searchVO);

	/**
	 * 공지사항의 상담글 상세내용을 조회한다.
	 * @param int - 조회할 게시 일련번호
	 * @return EipOcuNoticeVO
	 * @exception Exception
	 */
	public EipOcuNoticeVO selectOcuNoticeView(int sn);

    /**
	 * EipOcuNotice 이전글 다음을 목록
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 이전글 다음글 목록
	 * @exception Exception
	 */
	public EipOcuNoticeVO selectOcuNoticePreView(EipOcuNoticeVO searchVO);

	/**
	 * 공지사항의 상담글 상세내용 조회시 조회수 업데이트
	 * @param int - 조회할 게시 일련번호
	 * @return void
	 * @exception Exception
	 */
	public void updateOcuNoticeInqireCo(int sn);
	
    /**
	 * EipOcuNotice 첨부파일 조회
	 * @param sn - 게시물 번호
	 * @return 첨부파일 목록
	 * @exception Exception
	 */
	public List<EipOcuNoticeVO> selectFileList(int sn);
	
	/**
	 * 페이지 사이즈 목록을 불러온다.
	 * @param searchCodeVO - 조회할 정보가 담긴 VO
	 * @return EipOnlineMajorCnslt 페이지 사이즈 목록
	 * @exception Exception
	 */
	public List<EipOcuNoticeVO> selectPageSizeList(EipOcuNoticeVO searchCodeVO);

}