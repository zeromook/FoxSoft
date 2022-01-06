package kcue.ast.eip.ocu.notice.service;

import kcue.common.util.StringUtil;

import org.springframework.ui.ModelMap;

import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * 공지사항을 위한 VO 클래스
 * @author 응용개발 장근석
 * @since 2015.08.26
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      		수정자          		수정내용
 *  -------    		--------    ---------------------------
 *  2015.08.26  	장근석    			최초 생성
 *  
 *  </pre>
 */
public class EipOcuNoticeVO {

	/** 기본검색조건 */
	/** 카테고리 */
	private String ctgryStr;
	/** 카테고리명 */
	private String ctgryName;
	/** 게시판코드 */
	private String bbsseCD;
	/** 검색 선택 콤보 */
	private String searchFindKeyword;
	/** 검색 입력 */
	private String searchKeyword;
	/** 구분 */
	private String sel_cl;


	/** 공지사항 조회 항목 */
	/** 글번호 */
	private int rnum = 0;
	/** 일련번호 */
	private int sn;
	/** 게시판구분코드 */
	private String bbs_se_cd;
	/** 게시판구분명 */
	private String bbs_se_nm;
	/** 카테고리구분코드 */
	private String ctgry_se_cd;
	/** 카테고리명 */
	private String ctgry_nm;
	/** 고정공지 여부 */
	private String fixing_notice_at;
	/** 본문 HTML 여부 */
	private String bdt_html_at;
	/** 제목 */
	private String sj;
	/** 내용 */
	private String cn;
	/** 조회수 */
	private String inqire_co;
	/** 답변번호 */
	private String ans_no;
	/** 수정일시 */
	private String upd_dt;
	/** 수정자ID */
	private String upd_usr_id;
	/** 수정자명 */
	private String upd_usr_nm;
	/** 수정IP/MAC */
	private String upd_ip_mac;
	/** 입력일시 */
	private String ins_dt;
	/** 입력자ID */
	private String ins_usr_id;
	/** 입력자명 */
	private String ins_usr_nm;
	/** 입력IP/MAC */
	private String ins_ip_mac;
	/** 학년도 */
	private String sch_year;
	/** 게시판분류 */
	private String bbs_cl;
	/** 대학코드 */
	private String univ_cd;
	/** 파일ID */
	private String file_id;
	/** 파일명 */
	private String file_nm;
	/** 파일 아이콘 */
	private String file_icon;
	/** 새글 아이콘 */
	private String new_icon;
	
	/** 공지사항 이전글, 다음글 항목 */
	/** 이전근 일련번호 */
	private int prev_sn;
	/** 이전글 제목 */
	private String prev_nm;
	/** 이전글 번호 */
	private String prev_rnum;
	/** 다음글 일련번호 */
	private int next_sn;
	/** 다음글 제목 */
	private String next_nm;
	/** 다음글 번호 */
	private String next_rnum;

	/** 전체 리스트수 */
	private int totalCount;
	/** view에서 오는지 확인값*/
	private String from_view;
//	private String key; => file_id로 대체함
//	private String fieldName;
	/** 원래 파일명 */
	private String origin_file_nm;
	/** 파일 순번 */	
	private String file_sn;
	/** 파일크기 */
	private long file_size;
	/** 파일유형 */
	private String mime_type;
	/** 파일경로 */
	private String file_path;
	

	/** 사용자 기본정보 조회 항목 */
	/** 사용자ID */
	private String usr_id;
	/** 사용자명 */
	private String usr_nm;
	/** 전화번호 */
	private String mp_no;
	/** SMS/이메일 수신여부 */
	private String sms_email_recptn_at;
	/** 개인식별키 */
	private String idkey;
	/** 이메일 */
	private String email;
	/** 고등학교명 */
	private String hgschl_nm;
	/** 대학명 */
	private String univ_nm;
	/** 사용자구분코드 */
	private String usr_se_cd;
	/** 계열코드 */
	private String sers_cd;
	/** 상담교사여부 */
	private String cnslt_tcher_at;
	/** 고등학교유형코드 */
	private String hgschl_ty_cd;
	/** 지역코드 */
	private String area_cd;

//	/** 페이징 처리*/
//	private String pageIndex;

    /** 현재페이지 */
    private int pageIndex = 1;
    
    /** 페이지갯수 */
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
    private int pageSize = 10;
    
    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;
    
    /** 페이징값 set*/
	public void setPageInfo(EgovPropertyService propertiesService, ModelMap model, int totCnt) {
		int iPageUnit = propertiesService.getInt("pageUnit");
		int iPageSize = propertiesService.getInt("pageSize");
		int iPageIndex = propertiesService.getInt("pageIndex");
		setPageInfo(propertiesService, model, totCnt, iPageUnit, iPageSize, iPageIndex);
	}
	/** 페이징 계산 */
	public void setPageInfo(EgovPropertyService propertiesService, ModelMap model, int totCnt, int pageUnit, int pageSize, int pageIndex) {
    	int firstIndex = 0;
    	int lastIndex = 0;
    	firstIndex = (pageIndex*pageSize)-pageSize;
    	lastIndex = pageIndex*pageSize;
    	if(lastIndex >= totCnt){
    		lastIndex = totCnt;
    	}else{
    		lastIndex = pageIndex*pageSize;
    	}
		this.setFirstIndex(firstIndex);
		this.setLastIndex(lastIndex);
   }
	/**
	 * @return the ctgryStr
	 */
	public String getCtgryStr() {
		return ctgryStr;
	}
	/**
	 * @param ctgryStr the ctgryStr to set
	 */
	public void setCtgryStr(String ctgryStr) {
		this.ctgryStr = ctgryStr;
	}
	/**
	 * @return the ctgryName
	 */
	public String getCtgryName() {
		return ctgryName;
	}
	/**
	 * @param ctgryName the ctgryName to set
	 */
	public void setCtgryName(String ctgryName) {
		this.ctgryName = ctgryName;
	}
	/**
	 * @return the bbsseCD
	 */
	public String getBbsseCD() {
		return bbsseCD;
	}
	/**
	 * @param bbsseCD the bbsseCD to set
	 */
	public void setBbsseCD(String bbsseCD) {
		this.bbsseCD = bbsseCD;
	}
	/**
	 * @return the searchFindKeyword
	 */
	public String getSearchFindKeyword() {
		return searchFindKeyword;
	}
	/**
	 * @param searchFindKeyword the searchFindKeyword to set
	 */
	public void setSearchFindKeyword(String searchFindKeyword) {
		this.searchFindKeyword = searchFindKeyword;
	}
	/**
	 * @return the searchKeyword
	 */
	public String getSearchKeyword() {
		return StringUtil.getHtmlStrCnvr(searchKeyword);
	}
	/**
	 * @param searchKeyword the searchKeyword to set
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = StringUtil.getHtmlStrCnvr(searchKeyword);
	}
	/**
	 * @return the sel_cl
	 */
	public String getSel_cl() {
		return sel_cl;
	}
	/**
	 * @param sel_cl the sel_cl to set
	 */
	public void setSel_cl(String sel_cl) {
		this.sel_cl = sel_cl;
	}
	/**
	 * @return the rnum
	 */
	public int getRnum() {
		return rnum;
	}
	/**
	 * @param rnum the rnum to set
	 */
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	/**
	 * @return the sn
	 */
	public int getSn() {
		return sn;
	}
	/**
	 * @param sn the sn to set
	 */
	public void setSn(int sn) {
		this.sn = sn;
	}
	/**
	 * @return the bbs_se_cd
	 */
	public String getBbs_se_cd() {
		return bbs_se_cd;
	}
	/**
	 * @param bbs_se_cd the bbs_se_cd to set
	 */
	public void setBbs_se_cd(String bbs_se_cd) {
		this.bbs_se_cd = bbs_se_cd;
	}
	/**
	 * @return the bbs_se_nm
	 */
	public String getBbs_se_nm() {
		return bbs_se_nm;
	}
	/**
	 * @param bbs_se_nm the bbs_se_nm to set
	 */
	public void setBbs_se_nm(String bbs_se_nm) {
		this.bbs_se_nm = bbs_se_nm;
	}
	/**
	 * @return the ctgry_se_cd
	 */
	public String getCtgry_se_cd() {
		return ctgry_se_cd;
	}
	/**
	 * @param ctgry_se_cd the ctgry_se_cd to set
	 */
	public void setCtgry_se_cd(String ctgry_se_cd) {
		this.ctgry_se_cd = ctgry_se_cd;
	}
	/**
	 * @return the ctgry_nm
	 */
	public String getCtgry_nm() {
		return ctgry_nm;
	}
	/**
	 * @param ctgry_nm the ctgry_nm to set
	 */
	public void setCtgry_nm(String ctgry_nm) {
		this.ctgry_nm = ctgry_nm;
	}
	/**
	 * @return the fixing_notice_at
	 */
	public String getFixing_notice_at() {
		return fixing_notice_at;
	}
	/**
	 * @param fixing_notice_at the fixing_notice_at to set
	 */
	public void setFixing_notice_at(String fixing_notice_at) {
		this.fixing_notice_at = fixing_notice_at;
	}
	/**
	 * @return the bdt_html_at
	 */
	public String getBdt_html_at() {
		return bdt_html_at;
	}
	/**
	 * @param bdt_html_at the bdt_html_at to set
	 */
	public void setBdt_html_at(String bdt_html_at) {
		this.bdt_html_at = bdt_html_at;
	}
	/**
	 * @return the sj
	 */
	public String getSj() {
		return sj;
	}
	/**
	 * @param sj the sj to set
	 */
	public void setSj(String sj) {
		this.sj = sj;
	}
	/**
	 * @return the cn
	 */
	public String getCn() {
//		String rtCn = StringUtil.convertTag(cn);
		return cn;
	}
	/**
	 * @param cn the cn to set
	 */
	public void setCn(String cn) {
		this.cn = cn;
	}
	/**
	 * @return the inqire_co
	 */
	public String getInqire_co() {
		return inqire_co;
	}
	/**
	 * @param inqire_co the inqire_co to set
	 */
	public void setInqire_co(String inqire_co) {
		this.inqire_co = inqire_co;
	}
	/**
	 * @return the ans_no
	 */
	public String getAns_no() {
		return ans_no;
	}
	/**
	 * @param ans_no the ans_no to set
	 */
	public void setAns_no(String ans_no) {
		this.ans_no = ans_no;
	}
	/**
	 * @return the upd_dt
	 */
	public String getUpd_dt() {
		return upd_dt;
	}
	/**
	 * @param upd_dt the upd_dt to set
	 */
	public void setUpd_dt(String upd_dt) {
		this.upd_dt = upd_dt;
	}
	/**
	 * @return the upd_usr_id
	 */
	public String getUpd_usr_id() {
		return upd_usr_id;
	}
	/**
	 * @param upd_usr_id the upd_usr_id to set
	 */
	public void setUpd_usr_id(String upd_usr_id) {
		this.upd_usr_id = upd_usr_id;
	}
	/**
	 * @return the upd_usr_nm
	 */
	public String getUpd_usr_nm() {
		return upd_usr_nm;
	}
	/**
	 * @param upd_usr_nm the upd_usr_nm to set
	 */
	public void setUpd_usr_nm(String upd_usr_nm) {
		this.upd_usr_nm = upd_usr_nm;
	}
	/**
	 * @return the upd_ip_mac
	 */
	public String getUpd_ip_mac() {
		return upd_ip_mac;
	}
	/**
	 * @param upd_ip_mac the upd_ip_mac to set
	 */
	public void setUpd_ip_mac(String upd_ip_mac) {
		this.upd_ip_mac = upd_ip_mac;
	}
	/**
	 * @return the ins_dt
	 */
	public String getIns_dt() {
		return ins_dt;
	}
	/**
	 * @param ins_dt the ins_dt to set
	 */
	public void setIns_dt(String ins_dt) {
		this.ins_dt = ins_dt;
	}
	/**
	 * @return the ins_usr_id
	 */
	public String getIns_usr_id() {
		return ins_usr_id;
	}
	/**
	 * @param ins_usr_id the ins_usr_id to set
	 */
	public void setIns_usr_id(String ins_usr_id) {
		this.ins_usr_id = ins_usr_id;
	}
	/**
	 * @return the ins_usr_nm
	 */
	public String getIns_usr_nm() {
		return ins_usr_nm;
	}
	/**
	 * @param ins_usr_nm the ins_usr_nm to set
	 */
	public void setIns_usr_nm(String ins_usr_nm) {
		this.ins_usr_nm = ins_usr_nm;
	}
	/**
	 * @return the ins_ip_mac
	 */
	public String getIns_ip_mac() {
		return ins_ip_mac;
	}
	/**
	 * @param ins_ip_mac the ins_ip_mac to set
	 */
	public void setIns_ip_mac(String ins_ip_mac) {
		this.ins_ip_mac = ins_ip_mac;
	}
	/**
	 * @return the sch_year
	 */
	public String getSch_year() {
		return sch_year;
	}
	/**
	 * @param sch_year the sch_year to set
	 */
	public void setSch_year(String sch_year) {
		this.sch_year = sch_year;
	}
	/**
	 * @return the bbs_cl
	 */
	public String getBbs_cl() {
		return bbs_cl;
	}
	/**
	 * @param bbs_cl the bbs_cl to set
	 */
	public void setBbs_cl(String bbs_cl) {
		this.bbs_cl = bbs_cl;
	}
	/**
	 * @return the univ_cd
	 */
	public String getUniv_cd() {
		return univ_cd;
	}
	/**
	 * @param univ_cd the univ_cd to set
	 */
	public void setUniv_cd(String univ_cd) {
		this.univ_cd = univ_cd;
	}
	/**
	 * @return the file_id
	 */
	public String getFile_id() {
		return file_id;
	}
	/**
	 * @param file_id the file_id to set
	 */
	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}
	/**
	 * @return the file_nm
	 */
	public String getFile_nm() {
		return file_nm;
	}
	/**
	 * @param file_nm the file_nm to set
	 */
	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}
	/**
	 * @return the file_icon
	 */
	public String getFile_icon() {
		return file_icon;
	}
	/**
	 * @param file_icon the file_icon to set
	 */
	public void setFile_icon(String file_icon) {
		this.file_icon = file_icon;
	}
	/**
	 * @return the new_icon
	 */
	public String getNew_icon() {
		return new_icon;
	}
	/**
	 * @param new_icon the new_icon to set
	 */
	public void setNew_icon(String new_icon) {
		this.new_icon = new_icon;
	}
	/**
	 * @return the prev_sn
	 */
	public int getPrev_sn() {
		return prev_sn;
	}
	/**
	 * @param prev_sn the prev_sn to set
	 */
	public void setPrev_sn(int prev_sn) {
		this.prev_sn = prev_sn;
	}
	/**
	 * @return the prev_nm
	 */
	public String getPrev_nm() {
		return prev_nm;
	}
	/**
	 * @param prev_nm the prev_nm to set
	 */
	public void setPrev_nm(String prev_nm) {
		this.prev_nm = prev_nm;
	}
	/**
	 * @return the prev_rnum
	 */
	public String getPrev_rnum() {
		return prev_rnum;
	}
	/**
	 * @param prev_rnum the prev_rnum to set
	 */
	public void setPrev_rnum(String prev_rnum) {
		this.prev_rnum = prev_rnum;
	}
	/**
	 * @return the next_sn
	 */
	public int getNext_sn() {
		return next_sn;
	}
	/**
	 * @param next_sn the next_sn to set
	 */
	public void setNext_sn(int next_sn) {
		this.next_sn = next_sn;
	}
	/**
	 * @return the next_nm
	 */
	public String getNext_nm() {
		return next_nm;
	}
	/**
	 * @param next_nm the next_nm to set
	 */
	public void setNext_nm(String next_nm) {
		this.next_nm = next_nm;
	}
	/**
	 * @return the next_rnum
	 */
	public String getNext_rnum() {
		return next_rnum;
	}
	/**
	 * @param next_rnum the next_rnum to set
	 */
	public void setNext_rnum(String next_rnum) {
		this.next_rnum = next_rnum;
	}
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * @return the origin_file_nm
	 */
	public String getOrigin_file_nm() {
		return origin_file_nm;
	}
	/**
	 * @param origin_file_nm the origin_file_nm to set
	 */
	public void setOrigin_file_nm(String origin_file_nm) {
		this.origin_file_nm = origin_file_nm;
	}
	/**
	 * @return the file_sn
	 */
	public String getFile_sn() {
		return file_sn;
	}
	/**
	 * @param file_sn the file_sn to set
	 */
	public void setFile_sn(String file_sn) {
		this.file_sn = file_sn;
	}
	/**
	 * @return the file_size
	 */
	public long getFile_size() {
		return file_size;
	}
	/**
	 * @param file_size the file_size to set
	 */
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	/**
	 * @return the mime_type
	 */
	public String getMime_type() {
		return mime_type;
	}
	/**
	 * @param mime_type the mime_type to set
	 */
	public void setMime_type(String mime_type) {
		this.mime_type = mime_type;
	}
	/**
	 * @return the file_path
	 */
	public String getFile_path() {
		return file_path;
	}
	/**
	 * @param file_path the file_path to set
	 */
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	/**
	 * @return the usr_id
	 */
	public String getUsr_id() {
		return usr_id;
	}
	/**
	 * @param usr_id the usr_id to set
	 */
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	/**
	 * @return the usr_nm
	 */
	public String getUsr_nm() {
		return usr_nm;
	}
	/**
	 * @param usr_nm the usr_nm to set
	 */
	public void setUsr_nm(String usr_nm) {
		this.usr_nm = usr_nm;
	}
	/**
	 * @return the mp_no
	 */
	public String getMp_no() {
		return mp_no;
	}
	/**
	 * @param mp_no the mp_no to set
	 */
	public void setMp_no(String mp_no) {
		this.mp_no = mp_no;
	}
	/**
	 * @return the sms_email_recptn_at
	 */
	public String getSms_email_recptn_at() {
		return sms_email_recptn_at;
	}
	/**
	 * @param sms_email_recptn_at the sms_email_recptn_at to set
	 */
	public void setSms_email_recptn_at(String sms_email_recptn_at) {
		this.sms_email_recptn_at = sms_email_recptn_at;
	}
	/**
	 * @return the idkey
	 */
	public String getIdkey() {
		return idkey;
	}
	/**
	 * @param idkey the idkey to set
	 */
	public void setIdkey(String idkey) {
		this.idkey = idkey;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the hgschl_nm
	 */
	public String getHgschl_nm() {
		return hgschl_nm;
	}
	/**
	 * @param hgschl_nm the hgschl_nm to set
	 */
	public void setHgschl_nm(String hgschl_nm) {
		this.hgschl_nm = hgschl_nm;
	}
	/**
	 * @return the univ_nm
	 */
	public String getUniv_nm() {
		return univ_nm;
	}
	/**
	 * @param univ_nm the univ_nm to set
	 */
	public void setUniv_nm(String univ_nm) {
		this.univ_nm = univ_nm;
	}
	/**
	 * @return the usr_se_cd
	 */
	public String getUsr_se_cd() {
		return usr_se_cd;
	}
	/**
	 * @param usr_se_cd the usr_se_cd to set
	 */
	public void setUsr_se_cd(String usr_se_cd) {
		this.usr_se_cd = usr_se_cd;
	}
	/**
	 * @return the sers_cd
	 */
	
	public String getSers_cd() {
		return sers_cd;
	}
	/**
	 * @return the from_view
	 */
	public String getFrom_view() {
		return from_view;
	}
	/**
	 * @param from_view the from_view to set
	 */
	public void setFrom_view(String from_view) {
		this.from_view = from_view;
	}
	/**
	 * @param sers_cd the sers_cd to set
	 */
	public void setSers_cd(String sers_cd) {
		this.sers_cd = sers_cd;
	}
	/**
	 * @return the cnslt_tcher_at
	 */
	public String getCnslt_tcher_at() {
		return cnslt_tcher_at;
	}
	/**
	 * @param cnslt_tcher_at the cnslt_tcher_at to set
	 */
	public void setCnslt_tcher_at(String cnslt_tcher_at) {
		this.cnslt_tcher_at = cnslt_tcher_at;
	}
	/**
	 * @return the hgschl_ty_cd
	 */
	public String getHgschl_ty_cd() {
		return hgschl_ty_cd;
	}
	/**
	 * @param hgschl_ty_cd the hgschl_ty_cd to set
	 */
	public void setHgschl_ty_cd(String hgschl_ty_cd) {
		this.hgschl_ty_cd = hgschl_ty_cd;
	}
	/**
	 * @return the area_cd
	 */
	public String getArea_cd() {
		return area_cd;
	}
	/**
	 * @param area_cd the area_cd to set
	 */
	public void setArea_cd(String area_cd) {
		this.area_cd = area_cd;
	}
	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}
	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	/**
	 * @return the pageUnit
	 */
	public int getPageUnit() {
		return pageUnit;
	}
	/**
	 * @param pageUnit the pageUnit to set
	 */
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the firstIndex
	 */
	public int getFirstIndex() {
		return firstIndex;
	}
	/**
	 * @param firstIndex the firstIndex to set
	 */
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	/**
	 * @return the lastIndex
	 */
	public int getLastIndex() {
		return lastIndex;
	}
	/**
	 * @param lastIndex the lastIndex to set
	 */
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	
}