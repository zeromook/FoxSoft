package kcue.common.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**  
 * @Class Name : SessionUtils.java
 * @Description : SessionUtils Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2012.06.14           최초생성
 * 
 * @author 폭스소프트 개발팀
 * @since 2012.06.14
 * @version 1.0
 * @see
 */
public class SessionUtils {
	
    private HttpSession session = null;
    
    public SessionUtils(){
    	 this(false);
    }
    
    /**
     * 세션을 가져온다.
     * @param isNew true인경우 세션을 새로 생성한다.
     */
    public SessionUtils(boolean isNew){
        if(isNew){
            this.session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(true);
        }else{
            this.session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        } 
    }
    
    /**
     * 세션
     */
    public HttpSession getSession(){
        
    	return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    	
    }
    
    /**
     * 로그인 여부
     */
    public boolean isLogin(){
        if( null == this.session.getAttribute("isLogin") ) {
            return false;
        }else if( (boolean)this.session.getAttribute("isLogin").equals(false)) {
            return false;
        }else{
            return true;
        }
    }
    public void setIsLogin(boolean isLogin){
    	this.session.setAttribute("isLogin", isLogin);
    }
    
    /**
     * 회원, 비회원 구분
     */
    public boolean isMember(){
        if( null == this.session.getAttribute("isMember") ) {
            return false;
        }else if( (boolean)this.session.getAttribute("isMember").equals(false)) {
            return false;
        }else{
            return true; 
        }
    }
    public void setIsMember(boolean isMember){
    	this.session.setAttribute("isMember", isMember);
    }
    
    /**
     * 인터페이스 실행여부(실명인증, 메일발송등 실행여부)
     */
	public boolean isInterface(){
        if( null == this.session.getAttribute("interface") ) {
            return true;
        }else if( (boolean)this.session.getAttribute("interface").equals(false)) {
            return false;
        }else{
            return true;
        }
    }
    public void setIsInterface(boolean isInterface){
        this.session.setAttribute("interface", isInterface);
    }
    
    /**
     * 모니터단여부
     */
    public String getMonitorYn(){
    	return (String)this.session.getAttribute("monitorYn");
    }
    public void setMonitorYn(String monitorYn){
    	this.session.setAttribute("monitorYn", monitorYn);
    }
    
    /**
     * 회원 ID
     */
    public String getMberId(){
        return (String)this.session.getAttribute("mberId");
    }
    public void setMberId(String mberId){
        this.session.setAttribute("mberId", mberId);
    }
    
    /**
     * 회원 비밀번호
     */
    public String getMberPwd(){
        return (String)this.session.getAttribute("mberPwd");
    }
    public void setMberPwd(String mberPwd){
        this.session.setAttribute("mberPwd", mberPwd);
    }
    
    /**
     * 회원 비밀번호
     */
    public String getRqestPwd(){
        return (String)this.session.getAttribute("rqestPwd");
    }
    public void setRqestPwd(String rqestPwd){
        this.session.setAttribute("rqestPwd", rqestPwd);
    }
    
    /**
     * 회원명
     */
    public String getMberNm(){
        return (String)this.session.getAttribute("mberNm");
    }
    public void setMberNm(String mberNm){
        this.session.setAttribute("mberNm", mberNm);
    }
    
    /**
     * 회원 구분코드(개인, 법인, 단체)
     */
    public String getMberSeCd(){
        return (String)this.session.getAttribute("mberSeCd");
    }
    public void setMberSeCd(String mberSeCd){
        this.session.setAttribute("mberSeCd", mberSeCd);
    }
    
    /**
     * 회원 구분명(개인, 법인, 단체)
     */
    public String getMberSeNm(){
        return (String)this.session.getAttribute("mberSeNm");
    }
    public void setMberSeNm(String mberSeNm){
        this.session.setAttribute("mberSeNm", mberSeNm);
    }
    
    /**
     * 주민/외국인/법인/등록번호
     */
    public String getJurirNo(){
        return (String)this.session.getAttribute("jurirNo");
    }
    public void setJurirNo(String jurirNo){
        this.session.setAttribute("jurirNo", jurirNo);
    }
    
    /**
     * 뒷자리 숨김 처리된 주민/외국인/법인/등록번호
     */
    public String getHiddenJurirNo(){
        return (String)this.session.getAttribute("hiddenJurirNo");
    }
    public void setHiddenJurirNo(String hiddenJurirNo){
        this.session.setAttribute("hiddenJurirNo", hiddenJurirNo);
    }
    
    /**
     * 사업자 등록번호
     */
    public String getBizrNo(){
        return (String)this.session.getAttribute("bizrNo");
    }
    public void setBizrNo(String bizrNo){
        this.session.setAttribute("bizrNo", bizrNo);
    }
    
    /**
     * 회원 인증서유무
     */
    public String isCrtfctCn(){
        if( null == this.session.getAttribute("isCrtfctCn") ) {
            return "N";
        }else if( this.session.getAttribute("isCrtfctCn").equals("N") ) {
            return "N";
        }else{
            return "Y";
        }
    }
    public void setIsCrtfctCn(String isCrtfctCn){
    	this.session.setAttribute("isCrtfctCn", isCrtfctCn);
    }
    
    /**
     * 회원 E-MAIL 수신여부
     */
    public String getEmailRcpYn(){
        if( null == this.session.getAttribute("emailRcpYn") ) {
            return "N";
        }else if( this.session.getAttribute("emailRcpYn").equals("N") ) {
            return "N";
        }else{
            return "Y";
        }
    }
    public void setEmailRcpYn(String emailRcpYn){
    	this.session.setAttribute("emailRcpYn", emailRcpYn);
    }
    
    /**
     * 회원 SMS 수신여부
     */
    public String getSmsRcpYn(){
        if( null == this.session.getAttribute("smsRcpYn") ) {
            return "N";
        }else if( this.session.getAttribute("smsRcpYn").equals("N") ) {
            return "N";
        }else{
            return "Y";
        }
    }
    public void setSmsRcpYn(String smsRcpYn){
    	this.session.setAttribute("smsRcpYn", smsRcpYn);
    }
    
    /**
     * 우편번호
     */
	public String getZipCode(){
        return (String)this.session.getAttribute("zipCode");
    }
    public void setZipCode(String zipCode){
        this.session.setAttribute("zipCode", zipCode);
    }
    
    /**
     * 기본주소
     */
	public String getAddr1(){
        return (String)this.session.getAttribute("addr1");
    }
    public void setAddr1(String addr1){
        this.session.setAttribute("addr1", addr1);
    }
    
    /**
     * 상세주소
     */
	public String getAddr2(){
        return (String)this.session.getAttribute("addr2");
    }
    public void setAddr2(String addr2){
        this.session.setAttribute("addr2", addr2);
    }
    
    /**
     * 유선전화번호
     */
	public String getTelNo(){
        return (String)this.session.getAttribute("telNo");
    }
    public void setTelNo(String telNo){
        this.session.setAttribute("telNo", telNo);
    }
    
    /**
     * 휴대전화번호
     */
	public String getHpNo(){
        return (String)this.session.getAttribute("hpNo");
    }
    public void setHpNo(String hpNo){
        this.session.setAttribute("hpNo", hpNo);
    }
    
    /**
     * 이메일
     */
	public String getEmail(){
        return (String)this.session.getAttribute("email");
    }
    public void setEmail(String email){
        this.session.setAttribute("email", email);
    }
    
    /**
     * GPKI
     */
	public String getGpkiSession(){
        return (String)this.session.getAttribute("gpkiSession");
    }
    public void setGpkiSession(String gpkiSession){
        this.session.setAttribute("gpkiSession", gpkiSession);
    }
    
//    /**
//     * 사용자 기관 코드
//     */
//    public String getUserNstCd(){
//        return (String)this.session.getAttribute("userNstCd");
//    }
//    public void setUserNstCd(String userNstCd){
//        this.session.setAttribute("userNstCd", userNstCd);
//    }
//    
//    /**
//     * 사용자 기관 코드 명
//     */
//    public String getUserNstCdNm(){
//        return (String)this.session.getAttribute("userNstCdNm");
//    }
//    public void setUserNstCdNm(String userNstCdNm){
//        this.session.setAttribute("userNstCdNm", userNstCdNm);
//    }
    
    /**
     * 리다이렉트 URL
     */
    public String getRedirectUrl(){
        return (String)this.session.getAttribute("redirectUrl");
    }
    public void setRedirectUrl(String redirectUrl){
        this.session.setAttribute("redirectUrl", redirectUrl);
    }
    
    /**
     * 로그인 시간
     */
    public long getLoginTimeMs(){
        return ((Long)this.session.getAttribute("loginTimeMs")).longValue();
    }
    public void setLoginTimeMs(long loginTimeMs){
        this.session.setAttribute("loginTimeMs", new Long(loginTimeMs));
    }
    
    /**
     * 최근 로그인 날짜
     */
    public String getLstLoginYmd(){
        return ((String)this.session.getAttribute("lstLoginYmd"));
    }
    public void setLstLoginYmd(String lstLoginYmd){
        this.session.setAttribute("lstLoginYmd", lstLoginYmd);
    }
    
    /**
     * 최근 로그인 시간
     */
    public String getLstLoginHms(){
        return ((String)this.session.getAttribute("lstLoginHms"));
    }
    public void setLstLoginHms(String lstLoginHms){
        this.session.setAttribute("lstLoginHms", lstLoginHms);
    }
    
    /**
     * GPin 사용자 ip
     */
    public String getGpinUserIP(){
        return ((String)this.session.getAttribute("gpinUserIP"));
    }
    public void setGpinUserIP(String gpinUserIP){
        this.session.setAttribute("gpinUserIP", gpinUserIP);
    }
    
    /**
     * GPin 에서 처리해 주는 session
     */
    // 중복확인코드
    public String getDupInfo(){
        return ((String)this.session.getAttribute("dupInfo"));
    }
    // 개인식별번호
    public String getVirtualNo(){
        return ((String)this.session.getAttribute("virtualNo"));
    }
    // 이름
    public String getRealName(){
        return ((String)this.session.getAttribute("realName"));
    }
    // 사용자 등록 확인 결과
    public String getCoInfo1(){
        return ((String)this.session.getAttribute("coInfo1"));
    }
    public String getCoInfo2(){
        return ((String)this.session.getAttribute("coInfo2"));
    }
    public String getCiupdateo(){
        return ((String)this.session.getAttribute("ciupdate"));
    }
    // 성별
    public String getSex(){
        return ((String)this.session.getAttribute("sex"));
    }
    // 나이
    public String getAge(){
        return ((String)this.session.getAttribute("age"));
    }
    // 생년월일
    public String getBirthDate(){
        return ((String)this.session.getAttribute("birthDate"));
    }
    // 국적
    public String getNationalInfo(){
        return ((String)this.session.getAttribute("nationalInfo"));
    }
    // 본인인증방법
    public String getAuthInfo(){
        return ((String)this.session.getAttribute("authInfo"));
    }
    
    /**
     *  세션 아이디를 가져옵니다 
     * @return
     */
    public String getSessionId(){
        return (String)session.getId();
    }
    
    /**
     * 세션 유지 시간지정 
     * @return
     */
    public int getMaxInactiveInterval(){
        return this.session.getMaxInactiveInterval();
    }
    public void setMaxInactiveInterval(int maxInactiveInterval){
        this.session.setMaxInactiveInterval(maxInactiveInterval);
    }
    
    
    /**
     * 세션 소멸
     * @return
     */
    public void removeSession(){
        
        this.session.invalidate();
         
    }
    
    /**
     * 캡차ID
     */
    public String getCaptchaId(){
        return ((String)this.session.getAttribute("captchaId"));
    }
    public void setCaptchaId(String captchaId){
        this.session.setAttribute("captchaId", captchaId);
    }
}
