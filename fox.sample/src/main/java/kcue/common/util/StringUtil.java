/* 
 * 대학입학정보포털 사이트
 * 
 * 한국대학교육협의회
 * 폭스소프트 개발팀
 */
package kcue.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import kcue.common.exception.MessageException;
import kcue.common.interceptor.KcueLoggingInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

/**  
 * @Class Name : StringUtil.java
 * @Description : StringUtil Class
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
public class StringUtil {
	
	/** log 처리 서비스 */
	private static final Logger logger = LoggerFactory.getLogger(KcueLoggingInterceptor.class);

	/** MessageSourceService */
	@Resource(name="messageSource")
	private static MessageSource messageSource; 
	
	/**
	 * <pre>
	 * 문자열이 널이거나 빈 공백문자열인지 CHECK 한다
	 *  ex) isEmpty("")  => true
	 *  ex) isEmpty(" ") => false
	 * </pre>
	 * @param str 체크할 문자열
	 * @return boolean 널이거나 공백일 경우 true, 아닐경우 false
	 * @throws Exception
	 */
	public static boolean isEmpty(String str) {
		
		if (str == null || str.length() == 0) {
			return true;
		}
		
		return false;
	}

	/**
	 * <pre>
	 * 문자열이 널이거나 빈 공백문자열인지 CHECK 한다
	 *  ex) isEmptys(" ") => true
	 * </pre>
	 * @param str 체크할 문자열
	 * @return boolean 널이거나 공백일 경우 true, 아닐경우 false
	 * @throws Exception
	 */
	public static boolean isEmpty2(String str) {
		
		if (str == null || str.trim().length() == 0) {
			return true;
		}

		return false;
	}

	/**
	 * Method strCut. 문자열 바이트수만큼 끊어주고, 생략표시하기
	 * 
	 * @param strInput 문자열
	 * @param i 글자수
	 * @return String 
	*/
	public static String strCut(String strInput, int byteSize) throws Exception {

		if (isEmpty(strInput)) {
			return "";
		}

		String strOutput = "";
		int len = 0;
		int rSize = 0;

		for (; rSize < strInput.length(); rSize++) {
			if (strInput.charAt(rSize) > 127) {
				len += 2;
			} else {
				len++;
			}

			if (len > byteSize) {
				strOutput = strInput.substring(0, rSize) + "...";
				break;
			}
		}

		strOutput = convertTag(strOutput);
		return strOutput;

	}

	/**
	 * Method isStrToNum. 문자열 숫자인지 체크
	 * 
	 * @param s 문자열
	 * @param type DOUBLE,INTEGER
	 * @return boolean 
	*/
	public static boolean isStrToNum(String s,String type){
		
		try {
			if(type.equals("DOUBLE")){
				Double.parseDouble(s);
			}else if(type.equals("INTEGER")){
				Integer.parseInt(s);
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * @param Mode
	 * @param strInput
	 * @return
	 */
	public static String getDateTime(String Mode, String strInput) {
		
		String strTemp = "";
		String retStr = "";

		if (strTemp.length() < 14) {
			strTemp = strInput + "00000000000000";
			strTemp = strInput.substring(0, 14);
		} else {
			strTemp = strInput;
		}

		if(Mode.equals("YMD")){
			retStr=strTemp.substring(0,4)+"년 "+strTemp.substring(4,6)+"월 "+strTemp.substring(6,8)+"일";
		}else if(Mode.equals("YMDH")){
			retStr=strTemp.substring(0,4)+"년 "+strTemp.substring(4,6)+"월 "+strTemp.substring(6,8)+"일 "+strTemp.substring(8,10)+"시";
		}else if(Mode.equals("YMDHM")){
			retStr=strTemp.substring(0,4)+"년 "+strTemp.substring(4,6)+"월 "+strTemp.substring(6,8)+"일 "+strTemp.substring(8,10)+"시 "+strTemp.substring(10,12)+"분";
		}else if(Mode.equals("YMDHMS")){
			retStr=strTemp.substring(0,4)+"년 "+strTemp.substring(4,6)+"월 "+strTemp.substring(6,8)+"일 "+strTemp.substring(8,10)+"시 "+strTemp.substring(10,12)+"분 "+strTemp.substring(12,14)+"초";
		}else if(Mode.equals("Y-M-D")){
			retStr=strTemp.substring(0,4)+"-"+strTemp.substring(4,6)+"-"+strTemp.substring(6,8)+"";
		}else if(Mode.equals("Y-M-D:H")){
			retStr=strTemp.substring(0,4)+"-"+strTemp.substring(4,6)+"-"+strTemp.substring(6,8)+" "+strTemp.substring(8,10)+"";
		}else if(Mode.equals("Y-M-D:H:M")){
			retStr=strTemp.substring(0,4)+"-"+strTemp.substring(4,6)+"-"+strTemp.substring(6,8)+" "+strTemp.substring(8,10)+":"+strTemp.substring(10,12)+"";
		}else if(Mode.equals("Y-M-D:H:M:S")){
			retStr=strTemp.substring(0,4)+"-"+strTemp.substring(4,6)+"-"+strTemp.substring(6,8)+" "+strTemp.substring(8,10)+":"+strTemp.substring(10,12)+":"+strTemp.substring(12,14)+"";
		}
		return retStr;
	}
	
    /**
     * 특수문자 변환
     * 
     * @param srcString
     * @return String
     */    
    public static String getHtmlStrCnvr(String srcString) {
    	
    	String tmpString = nchk(srcString);
    	
		tmpString = tmpString.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
		/*
		 *  2020.08.10 장창환 
		 *  가상키보드 부분 비밀번호 검증 부분에서 "#" 관련 변환이 없어 추가, 추후 "#" 변환으로 인한 오류 발생 시 "#" 삭제 후 관련 자바 파일 내에 replaceAll 처리
		 */
		tmpString = tmpString.replaceAll("&#35;", "#").replaceAll("&#38;", "&").replaceAll("&#34;", "\"").replaceAll("&#39;", "\'");
		tmpString = tmpString.replaceAll("&#40;", "(").replaceAll("&#41;", ")");
		
		return  tmpString;
	}
    
	/**
	 * 
	 * @param strInput
	 * @return
	 */
	public static String getComma(String strInput)
	{
		if (strInput == null) {
			return "";
		}
		
		String strOutput = "";
		strOutput = getReplace(strInput, '\'', "''");
		strOutput = getReplace(strInput, '<', "&lt;");
		strOutput = getReplace(strInput, '>', "&gt;");
		return strOutput;
	}
	
	
	/**
	 * @param strInput
	 * @return
	 */
	public static String EditorComma(String strInput)
	{
		if (strInput == null) {
			return "";
		}

		String strOutput = "";
		strOutput = getReplace(strInput, '\'', "&quot;");
		strOutput = getReplace(strInput, '\"', "&quot;");
		return strOutput;
	}

	
    /**
     * 특정문자 변환
     * 
     * @param srcString
     * @return String
     */    
    public static String getAllReplace(String strInput, String srcString, String chgString) {
    	
    	String tmpString = strInput;
		tmpString = tmpString.replaceAll(srcString, chgString);
		return  tmpString;
	}
	
	/**
	 * 입력된 문자열로부터 해당 Char를 찾아서 지정된 문자열로 변환한다.
	 * 
	 * @param strInput
	 * @param charOriginal
	 * @param strDestination
	 * @return
	 */
	public static String getReplace(String strInput, char charOriginal, String strDestination) 
	{
		String str = "";
		char chr;
		
		for (int i = 0; i < strInput.length(); i++) {
			chr = strInput.charAt(i);
			if (chr == charOriginal) {
				str += strDestination;
			} else {
				str += chr;
			}
		}

		return str;
	}
	/**
	 * Method strCut. 문자열 바이트수만큼 끊어주고, 생략표시하기
	 * 
	 * @param str 문자열
	 * @param i 글자수
	 * @return String
	*/
	public static int strByteSize(String str) throws Exception {
		
		if (isEmpty(str)) {
			return 0;
		}

		int len = 0;
		int rSize = 0;

		for (; rSize < str.length(); rSize++) {
			if (str.charAt(rSize) > 127)
				len += 2;
			else
				len++;
		}
		return len;

	}

	/**
	 * Method strCut. 문자열 바이트수만큼 끊어주고, 생략표시하기
	 * 
	 * @param str 문자열
	 * @param i 글자수
	 * @param tail 생략 문자열. 예) "..."
	 * @return String
	*/
	public static String strCut(String str, int i, String tail) throws Exception {
		
		if (isEmpty(str)) {
			return "";
		}

		if (str.length() < 4 || str.length() <= i) {
			return str;
		}

		return new String(str.substring(0, i - 3) + tail);
	}
	
	
	/**
	 * Method trimHTML. HTML 태그를 제거하는 메소드
	 * 
	 * @param src 문자열
	 * @return String
	 * @throws MessageException 
	 * @throws NoSuchMessageException 
	 */ 
	public static String trimHTML(String src) 
	{
		if (src == null) {
			return null; 
		}
		
		if (src.indexOf('<') == -1) {
			return src;
		}

		StringBuffer dest = new StringBuffer(); 

		try { 
			char oldstr='<';
			char oldstr2='>';

			int  len = 1; 
			int  srclen = src.length(); 
			int  pos = 0; 
			int  pos2=0;
			int  oldpos = 0; 

			while ((pos = src.indexOf(oldstr, oldpos)) >= 0)
			{ 
				dest.append(src.substring(oldpos, pos));
				oldpos = pos + len; 
				pos2 = src.indexOf(oldstr2, oldpos);
				oldpos = pos2 + len;                                   
			} 

			if (oldpos < srclen) 
				dest.append(src.substring(oldpos, srclen)); 

		} catch ( ArithmeticException e ) { 
			if(logger.isErrorEnabled()){
				logger.error(messageSource.getMessage("cmn.cmn.stringtrans", null, Locale.getDefault()));
			}
		} catch ( Exception e ) { 
			if(logger.isErrorEnabled()){
				logger.error(messageSource.getMessage("cmn.cmn.stringtrans", null, Locale.getDefault()));
			}
		} 
		return dest.toString(); 
	}
	
	/**
	 * 확장자를 잘라서 확인 하는 메소드(확장자를 반환함)
	 * 
	 * @param fnm
	 * @return
	 * @throws Exception
	 */
	public static String trimFnm(String fnm) throws Exception {

		String fileType = "";
		
		if (isEmpty(fnm)) {
			fileType = "none";
		} else {
			
			String checkString = ",hwp,doc,xls,icon_calendar,pdf,zip,ppt,txt,";
			
			fileType = fnm.substring(fnm.lastIndexOf(".") + 1);
			fileType = fileType.toLowerCase();
			
			if (checkString.indexOf(fileType) < 0) {
				fileType = "etc"; // 조건에 만족하지 못하면 etc로 반환
			}
		}
		

		return fileType;
	}
	
	/**
	 * 단순히 확장자만 리턴함
	 * 
	 * @param fnm
	 * @return
	 */
	public static String getExt(String fnm) {
		String fileType = "." + fnm.substring(fnm.lastIndexOf(".") + 1);

		return fileType;
	}
	
	/**
	 * @param strInput
	 * @return
	 * @throws Exception
	 */
	public static String encodeEuc(String strInput) throws Exception {
		
		if (isEmpty(strInput)) {
			return "";
		}
		
		String strOutput = "";

		try {
			strOutput = new String(strInput.getBytes("8859_1"), "ksc5601");
		} catch (UnsupportedEncodingException uee) {
			strOutput = "";
		}
		return strOutput;
	}

	/**
	 * @param strInput
	 * @return
	 * @throws Exception
	 */
	public static String encodeUni(String strInput) throws Exception {

		if (isEmpty(strInput)) {
			return "";
		}
		
		String strOutput = "";

		try {
			strOutput = new String(strInput.getBytes("ksc5601"), "8859_1");
		} catch (UnsupportedEncodingException uee) {
			strOutput = "";
		}
		return strOutput;
	}
   
	/**
	 * HTML 방지용 메소드
	 * 
	 * Method convertTag.
	 * @param strInput
	 * @return String
	 */
	public static String convertTag(String strInput) {
		if (strInput == null) {
			return "";
		}

		int length = 0;
		StringBuffer buffer = new StringBuffer();
		String comp = null;

		length = strInput.length();
		for (int i = 0; i < length; ++i) {
			comp = strInput.substring(i, i + 1);
			if ("<".compareTo(comp) == 0) {
				buffer.append("&lt;");
			} else if (">".compareTo(comp) == 0) {
				buffer.append("&gt;");
			} else if ("\"".compareTo(comp) == 0) {
				buffer.append("&quot;");
			} else {
				buffer.append(comp);
			}
		}
		return buffer.toString();
	}

	/**
	 * <pre>
	 * \n을 <BR>
	 * 로변경 Method convertBr.
	 * </pre>
	 * 
	 * @param strInput
	 * @return String
	 */
	public static String convertBr(String strInput) {
		if (strInput == null) {
			return "";
		}
		int length = 0;
		StringBuffer buffer = new StringBuffer();
		String comp = null;

		length = strInput.length();
		for (int i = 0; i < length; ++i) {
			comp = strInput.substring(i, i + 1);
			if ("\n".compareTo(comp) == 0) {
				buffer.append("<br>");
			} else {
				buffer.append(comp);
			}
		}
		return buffer.toString();
	}

	/**
	 * null 값을 공백으로 대체 Method nchk.
	 * 
	 * @param str
	 * @return String
	 */
	public static String nchk(String str) {
		return nchk(str, "");
	}

	/**
	 * null 값을 defaultStr 값으로 대체 Method nchk.
	 * 
	 * @param str
	 * @param defaultStr
	 * @return String
	 */
	public static String nchk(String str, String defaultStr) {
		return (str == null || str.equals("") || str.equals("null")) ? defaultStr
				: str;
	}
	
	/**
	 * value가 null인 경우 defalult값을 return
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public static int nvlTOint(Object value, int defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		else {
			if (value.toString().equals(""))
				return defaultValue;
			else
				return Integer.parseInt(value.toString());
		}
	}

	/**
	 * @param str
	 * @return
	 */
	public static int strTOint(String str) {
		int rtn = 0;
		try {
			if (str != null && !str.equals("")) {
				rtn = Integer.parseInt(str);
			}
		} catch (NumberFormatException e) {
			rtn = 0;
		}
		return rtn;
	}

	/**
	 * @param str
	 * @return
	 */
	public static long strTOlong(String str) {
		long rtn = 0;
		try {
			if (str != null && !str.equals("")) {
				rtn = Long.parseLong(str);

			}
		} catch (NumberFormatException e) {
			rtn = 0;
		}
		return rtn;
	}

	/**
	 * 문자열을 특정구분잘로 잘라서 해당 부분을 리턴한다
	 * 
	 * @param source
	 * @param gubun
	 * @param idx
	 * @return
	 */
	public static String split(String source, String gubun, int idx) {
		String[] temp = null;
		String str = "";
		int i = idx - 1;
		if (source == null || source.length() < 1)
			return "";
		if (source.indexOf(gubun) == -1)
			return "";
		if (i < 0)
			return "";

		temp = source.split(gubun);

		if (temp != null && (temp.length > i)) {
			str = temp[i];
		} else {
			str = "";
		}

		return str;
	}

	/**
	 * 문자열을 특정구분잘로 잘라서 해당 부분을 리턴한다
	 * 
	 * @param strInput
	 * @return
	 */
	public static String regTrimHTML(String strInput) {
		Pattern p = Pattern.compile("\\<(\\/?)(\\w+)*([^<>]*)>");
		Matcher m = p.matcher(strInput);
		String strOutput = m.replaceAll("");
		return strOutput;
	}

	/**
	 * @param source
	 * @param dest
	 * @return
	 */
	public static boolean Contains(String source, String dest) {
		if (source == null || dest == null) {
			return false;
		}
		
		if (!source.equals(dest)) {
			return false;
		}
		
		return true;
	}

	/**
	 * @param source
	 * @param dest
	 * @return
	 */
	public static String isChecked(String source, String dest) {

		if (Contains(source, dest)) {
			return "checked";
		}

		return "";
	}

	/**
	 * @param source
	 * @param dest
	 * @return
	 */
	public static String isSelected(String source, String dest) {
		if (Contains(source, dest)) {
			return "selected";
		}

		return "";
	}

	/**
	 * @param strInput
	 * @param strSrc
	 * @param strDest
	 * @return
	 * @throws Exception
	 */
	public static String replace(String strInput, String strSrc, String strDest) throws Exception {
		
		if (isEmpty(strInput)) return strInput;
		int index = 0;
		String strOutput = strInput;
		while ((index = strOutput.indexOf(strSrc, index)) >= 0) {
			strOutput = strOutput.substring(0, index) + strDest + strOutput.substring(index + strSrc.length());
			index += strDest.length();
		}
		return strOutput;
	}
	
	/**
	* 문자열의 왼쪽에 대체문자를 해당 index의 갯수만큼 채워 리턴한다.
	* @param str 변경할 문자열, index 반복횟수, addStr 반복될문자열
	* @return 오른쪽에 반복되어 채워진 문자열
	*/
	public static String fillLeft(String str, int index, String addStr) {
		int gap = 0;
		if ((str!=null) && (addStr!=null) && (str.length()<=index)) {
			gap = index - str.length();

			for(int i=0 ; i<gap ; i++) {
				str = addStr + str;
			}
			return str;
		}
		else {
			return "";
		}
	}
	
	/**
	 * 랜덤문자열을 생성한다.
	 * 
	 * @param size 생성할 문자열 길이
	 * @return 생성된 랜덤문자열
	 */
	public static String makeAlphaNumericRandom(int size) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		String str = "abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
		// 특수문자 #, & 는 XSSRequestWrapper 필터에서 문자 변환이 되어 넣지 못함.
		String str2 = "!@$%^*-_+=";
		String str3 = "23456789";
		int idx = 0;
		
		for ( int i = 0; i < size; i++) {
			// 6자리 까지는 알파벳, 7번째 특수문자, 8번째 숫자 (비밀번호 생성)
			if(i < (size-2)){
				idx = random.nextInt(str.length());
				sb.append(str.charAt(idx));
			}else if(i == (size-2)){
				idx = random.nextInt(str2.length());
				sb.append(str2.charAt(idx));
			}else if(i == size-1){
				idx = random.nextInt(str3.length());
				sb.append(str3.charAt(idx));
			}else{
				idx = random.nextInt(str.length());
				sb.append(str.charAt(idx));
			}
		}
		return sb.toString();
	}
	
	/**
	 * 글내용 저장시 script 안먹히게 적용
	 * 
	 * @param cn 문자열 내용
	 * @return script 태그 제외하고 생성된 문자열
	 */
	public static String convertScript(String cn) {
		String conCn = "";
		if(!isEmpty(cn)){
			conCn = cn.replaceAll("<script", "&lt;/script").replaceAll("< script", "&lt;script");
			conCn = conCn.replaceAll("</script", "&lt;/script").replaceAll("</ script", "&lt;/script");
		}
		return conCn;
	}
	
	/**
	 * 모든 HTML 태그를 제거하고 반환한다.
	 * 
	 * @param html
	 * @throws Exception  
	 */
	public static String removeTag(String html) throws Exception {
		html = html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=*[^>]*)?(\\s)*(/)?>", "");
		html = html.replaceAll("<!--.*-->", "");
		html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
		html = html.replaceAll("&nbsp;", " ");
		return html;
	}
}
