package kcue.ast.eip.ocu.answerboardlist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kcue.ast.eip.ocu.answerboardlist.service.EipOcuAnswerBoardListService;
import kcue.ast.eip.ocu.answerboardlist.service.EipOcuAnswerBoardListVO;
import kcue.ast.eip.ocu.answerboardlist.service.JogunVO;
/**
 * 답변게시판목록 작업을 위한 Controller 클래스
 * @author 정영묵
 * @since 2022.01.07
 * @version 1.0
 * @see
 */
@Controller
public class EipOcuAnswerBoardListController {

    /*EipOcuAnswerBoardListService*/
    @Resource(name="EipOcuAnswerBoardListService")
    protected EipOcuAnswerBoardListService eipOcuAnswerBoardListService;

	  /** Logger */
    final static Logger log = Logger.getLogger(EipOcuAnswerBoardListController.class);
    
    /** 답변게시판 목록 불러오기 */
    @RequestMapping(value="/kcue/ast/eip/ocu/answerboardlist/EipOcuAnswerBoardList.do")
    public String selectCodeList(ModelMap model,JogunVO vo) {
        System.out.println("Controller 들어옴-------------------");
	    List<JogunVO> inquiryConditions = eipOcuAnswerBoardListService.selectinquiryConditions(vo);
	    int boardCount = eipOcuAnswerBoardListService.getboardCount();
        model.addAttribute("inquiryConditions", inquiryConditions);//검색조건
        model.addAttribute("boardCount", boardCount);//글의 개수
	    return "kcue/ast/eip/ocu/answerboardlist/EipOcuAnswerBoardList";
    }
    
    
    @RequestMapping("/kcue/ast/eip/ocu/answerboardlist/updateAnswerBoardList.do")
    public ModelAndView updateAnswerBoardList(ModelAndView mv,String process_sttus,String searchFindKeyword,String inputtext) {
    	System.out.println("updateAnswerBoardList들어옴--------------------------");
    	Map<String,Object> mp = new HashMap<>();
    	mp.put("process_sttus", process_sttus);
    	mp.put("searchFindKeyword", searchFindKeyword);
    	mp.put("inputtext", inputtext);
    	List<EipOcuAnswerBoardListVO> AnswerBoardList = eipOcuAnswerBoardListService.selectAnswerBoardList(mp);
    	mv.setViewName("jsonView");
    	mv.addObject("UpdateAnswerBoardList", AnswerBoardList);
    	return mv;
    }
    
	
}
