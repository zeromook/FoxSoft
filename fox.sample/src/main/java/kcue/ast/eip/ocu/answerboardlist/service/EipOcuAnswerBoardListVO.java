package kcue.ast.eip.ocu.answerboardlist.service;

public class EipOcuAnswerBoardListVO {

	/*게시판 일련번호*/
	private int bbs_sn; 
	/*시스템구분코드 - [CMN03]*/
	private String sys_se_cd;
	/*학년도*/
	private String sch_year;
	/*그룹번호*/
	private int grp_no;
	/*그룹순번*/
	private int grp_sn;
	/*답변깊이*/
	private int ans_dp;
	/*긴급공지여부 - Y,N*/
	private String emrgncy_notice_at;
	/*사용자구분코드 - [CMN31]*/
	private String usr_se_cd;
	/*게시시작일자*/
	private String ntce_begin_de;
	/*게시종료일자*/
	private String ntce_end_de;
	/*제목*/
	private String sj;
	/*내용*/
	private String cn;
	/*조회수*/
	private int inqire_co;
	/*팝업공지여부*/
	private String popup_notice_at;
	/*공개여부*/
	private String othbc_at;
	/*파일ID*/
	private String file_id;
	/*처리상태 - [CMN15]*/
	private String process_sttus;
	/*답변자ID*/
	private String ans_usr_id;
	/*답변내용*/
	private String ans_cn;
	/*답변파일ID*/
	private String ans_file_id;
	/*답변일시*/
	private String ans_dt;
	/*메뉴ID*/
	private String mnu_id;
	/*수정일시*/
	private String upd_dt;
	/*수정자ID*/
	private String upd_usr_id;
	/*수정IP/MAC*/
	private String upd_ip_mac;
	/*입력일시*/
	private String ins_dt;
	/*입력자ID*/
	private String ins_usr_id;
	/*입력IP/MAC*/
	private String ins_ip_mac;
	
	
	
	
	
	public int getBbs_sn() {
		return bbs_sn;
	}
	public void setBbs_sn(int bbs_sn) {
		this.bbs_sn = bbs_sn;
	}
	public String getSys_se_cd() {
		return sys_se_cd;
	}
	public void setSys_se_cd(String sys_se_cd) {
		this.sys_se_cd = sys_se_cd;
	}
	public String getSch_year() {
		return sch_year;
	}
	public void setSch_year(String sch_year) {
		this.sch_year = sch_year;
	}
	public int getGrp_no() {
		return grp_no;
	}
	public void setGrp_no(int grp_no) {
		this.grp_no = grp_no;
	}
	public int getGrp_sn() {
		return grp_sn;
	}
	public void setGrp_sn(int grp_sn) {
		this.grp_sn = grp_sn;
	}
	public int getAns_dp() {
		return ans_dp;
	}
	public void setAns_dp(int ans_dp) {
		this.ans_dp = ans_dp;
	}
	public String getEmrgncy_notice_at() {
		return emrgncy_notice_at;
	}
	public void setEmrgncy_notice_at(String emrgncy_notice_at) {
		this.emrgncy_notice_at = emrgncy_notice_at;
	}
	public String getUsr_se_cd() {
		return usr_se_cd;
	}
	public void setUsr_se_cd(String usr_se_cd) {
		this.usr_se_cd = usr_se_cd;
	}
	public String getNtce_begin_de() {
		return ntce_begin_de;
	}
	public void setNtce_begin_de(String ntce_begin_de) {
		this.ntce_begin_de = ntce_begin_de;
	}
	public String getNtce_end_de() {
		return ntce_end_de;
	}
	public void setNtce_end_de(String ntce_end_de) {
		this.ntce_end_de = ntce_end_de;
	}
	public String getSj() {
		return sj;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public int getInqire_co() {
		return inqire_co;
	}
	public void setInqire_co(int inqire_co) {
		this.inqire_co = inqire_co;
	}
	public String getPopup_notice_at() {
		return popup_notice_at;
	}
	public void setPopup_notice_at(String popup_notice_at) {
		this.popup_notice_at = popup_notice_at;
	}
	public String getOthbc_at() {
		return othbc_at;
	}
	public void setOthbc_at(String othbc_at) {
		this.othbc_at = othbc_at;
	}
	public String getFile_id() {
		return file_id;
	}
	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}
	public String getProcess_sttus() {
		return process_sttus;
	}
	public void setProcess_sttus(String process_sttus) {
		this.process_sttus = process_sttus;
	}
	public String getAns_usr_id() {
		return ans_usr_id;
	}
	public void setAns_usr_id(String ans_usr_id) {
		this.ans_usr_id = ans_usr_id;
	}
	public String getAns_cn() {
		return ans_cn;
	}
	public void setAns_cn(String ans_cn) {
		this.ans_cn = ans_cn;
	}
	public String getAns_file_id() {
		return ans_file_id;
	}
	public void setAns_file_id(String ans_file_id) {
		this.ans_file_id = ans_file_id;
	}
	public String getAns_dt() {
		return ans_dt;
	}
	public void setAns_dt(String ans_dt) {
		this.ans_dt = ans_dt;
	}
	public String getMnu_id() {
		return mnu_id;
	}
	public void setMnu_id(String mnu_id) {
		this.mnu_id = mnu_id;
	}
	public String getUpd_dt() {
		return upd_dt;
	}
	public void setUpd_dt(String upd_dt) {
		this.upd_dt = upd_dt;
	}
	public String getUpd_usr_id() {
		return upd_usr_id;
	}
	public void setUpd_usr_id(String upd_usr_id) {
		this.upd_usr_id = upd_usr_id;
	}
	public String getUpd_ip_mac() {
		return upd_ip_mac;
	}
	public void setUpd_ip_mac(String upd_ip_mac) {
		this.upd_ip_mac = upd_ip_mac;
	}
	public String getIns_dt() {
		return ins_dt;
	}
	public void setIns_dt(String ins_dt) {
		this.ins_dt = ins_dt;
	}
	public String getIns_usr_id() {
		return ins_usr_id;
	}
	public void setIns_usr_id(String ins_usr_id) {
		this.ins_usr_id = ins_usr_id;
	}
	public String getIns_ip_mac() {
		return ins_ip_mac;
	}
	public void setIns_ip_mac(String ins_ip_mac) {
		this.ins_ip_mac = ins_ip_mac;
	}
	
	
}
