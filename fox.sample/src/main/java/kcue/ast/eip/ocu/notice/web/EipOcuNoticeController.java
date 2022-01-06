package kcue.ast.eip.ocu.notice.web;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kcue.ast.eip.ocu.notice.service.EipOcuNoticeService;
import kcue.ast.eip.ocu.notice.service.EipOcuNoticeVO;
import kcue.common.KcueDefaultVO;
import kcue.common.result.KcueResultVO;
import kcue.common.util.StringUtil;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * 공지사항 목록 작업을 위한 Controller 클래스
 * @author 응용개발 장근석
 * @since 2015.08.05
 * @version 1.0
 * @see
 */
@Controller
public class EipOcuNoticeController {

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService; 

	/** EgovPropertyService */
	@Resource(name = "EipOcuNoticeService")
	protected EipOcuNoticeService eipOcuNoticeService;
	
	  /** Logger */
    final static Logger log = Logger.getLogger(EipOcuNoticeController.class);
    
    /** MessageSourceService */
    @Resource(name = "messageSource")
    private MessageSource messageSource;
	
    
 @RequestMapping(value="/kcue/ast/eip/ocu/notice/EipOcuNoticeGesipan.do")
    public String selectGesipanList(ModelMap model) {
	 
	 System.out.println("컨트롤러들어옴----------------------------------------------------------------------------");
	 return "kcue/ast/eip/ocu/notice/EipOcuNoticeGesipan";
 }
    
    
    
    
    
    /**
	 * EipOcuNotice 초기값을 불러온다.
	 * @param
	 * @return modelAndView
	 * @exception Exception
	 */
	@RequestMapping(value="/kcue/ast/eip/ocu/notice/EipOcuNotice.do")
	public String selectCodeList(@ModelAttribute("eipOcuNoticeVO") EipOcuNoticeVO eipOcuNoticeVO
											, @ModelAttribute("searchVO") KcueDefaultVO searchVO
											, ModelMap model, HttpSession session) throws Exception{
		
		List<EipOcuNoticeVO> sel_cl = null;				// 조회 조건 분류
		List<EipOcuNoticeVO> pageSizeList = null;			// 출력건수
		
		//조회조건 분류
		sel_cl =  this.eipOcuNoticeService.selectOcuNoticeInquireCndList(eipOcuNoticeVO);
		pageSizeList = this.eipOcuNoticeService.selectPageSizeList(eipOcuNoticeVO);

		model.addAttribute("EipOcuNoticeVO", eipOcuNoticeVO);
		model.addAttribute("sel_cl", sel_cl);
		model.addAttribute("pageSizeList", pageSizeList);

		return "kcue/ast/eip/ocu/notice/EipOcuNoticeList";
	}
	
	/** 공지사항 목록 조회 */
	@RequestMapping(value="/kcue/ast/eip/ocu/notice/EipOcuNoticeList.do")
	public ModelAndView selectOcuNoticeList(@ModelAttribute("eipOcuNoticeVO") EipOcuNoticeVO eipOcuNoticeVO, ModelMap model, HttpSession session) {

		KcueResultVO resultVO = new KcueResultVO();		// 조회 결과 VO
		List<EipOcuNoticeVO> resultList = null;						// 공지사항 목록 리스트
		
		int totalCount = 0;											// 공지사항 목록 전체 건수
		int totalCount_org = 0;

		try {

			totalCount = this.eipOcuNoticeService.selectOcuNoticeToCnt(eipOcuNoticeVO);
			totalCount_org = this.eipOcuNoticeService.selectOcuNoticeToCntOrg(eipOcuNoticeVO);

			eipOcuNoticeVO.setTotalCount(totalCount);

			if(totalCount < 1){
				totalCount = 1;
			}
			//페이징 처리 firstIndex / lastIndex 셋팅
			eipOcuNoticeVO.setPageInfo(this.propertiesService, model, totalCount, eipOcuNoticeVO.getPageUnit(), eipOcuNoticeVO.getPageSize(), eipOcuNoticeVO.getPageIndex());
			resultVO.setResultCode("SUCCESS");
			//공지사항 목록 결과 조회
			resultList = this.eipOcuNoticeService.selectOcuNoticeList(eipOcuNoticeVO);	
		} catch (Exception e) {
			log.error(messageSource.getMessage("info.nodata.msg", null, Locale.KOREA));
			resultVO.setResultCode("ERROR");
			resultVO.setResultMessage(messageSource.getMessage("info.nodata.msg", null, Locale.KOREA));
		}

		
		//ajax로 할때 ModelAndView 사용해서 setViewName을 jsonView로----------------------------------------------
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		modelAndView.addObject("resultVO", resultVO);
		modelAndView.addObject("eipOcuNoticeVO", eipOcuNoticeVO);
		
		modelAndView.addObject("resultPageSize", eipOcuNoticeVO.getPageSize());
		modelAndView.addObject("resultPageUnit", eipOcuNoticeVO.getPageUnit());
	
		modelAndView.addObject("resultList", resultList);
		modelAndView.addObject("resultTotCnt", totalCount);
		modelAndView.addObject("resultTotCntOgr", totalCount_org);

		return modelAndView;
	}

	/** 공지사항 상세보기 */
	@RequestMapping(value="/kcue/ast/eip/ocu/notice/EipOcuNoticeView.do")
	public String selectOcuNoticeView(@RequestParam("p_menu_id") String p_menu_id
			, @RequestParam("sn") int sn
			, @RequestParam("rnum") int rnum 
			, @ModelAttribute("eipOcuNoticeVO") EipOcuNoticeVO eipOcuNoticeVO, ModelMap model) throws Exception{

		EipOcuNoticeVO eipView = null;
		EipOcuNoticeVO eipPreView = null;
		List<EipOcuNoticeVO> eipFileList=null;
		
		eipOcuNoticeVO.setSn(sn);
		
		if(StringUtil.isEmpty(eipOcuNoticeVO.getSearchFindKeyword())){
			eipOcuNoticeVO.setSearchFindKeyword("");
		}
		if(StringUtil.isEmpty(eipOcuNoticeVO.getSearchKeyword())){
			eipOcuNoticeVO.setSearchKeyword("");
		}
		if(StringUtil.isEmpty(eipOcuNoticeVO.getSel_cl())){
			eipOcuNoticeVO.setSel_cl("%");
		}
		
		
		eipOcuNoticeService.updateOcuNoticeInqireCo(sn);
		eipView = this.eipOcuNoticeService.selectOcuNoticeView(sn);
		eipView.setRnum(rnum);
		
		eipView.setCn(eipView.getCn().trim());
		
		eipFileList = this.eipOcuNoticeService.selectFileList(sn);
		
		eipPreView = this.eipOcuNoticeService.selectOcuNoticePreView(eipOcuNoticeVO);
		
		model.addAttribute("eipView", eipView);
		model.addAttribute("eipFileList", eipFileList);
		model.addAttribute("eipOcuNoticeVO", eipPreView);

		return "kcue/ast/eip/ocu/notice/EipOcuNoticeView";
	}

}
