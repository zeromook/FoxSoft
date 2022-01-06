/*
 * 대학입학정보포털 사이트
 * 
 * 한국대학교육협의회
 * 폭스소프트 개발팀
 */
package kcue.common.util;

import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

/**  
 * @Class Name : DateUtil.java
 * @Description : DateUtil Class
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
public class DateUtil {
	
	/**
	 * <pre>
	 * 입력 날짜에 입력숫자만큼 더한 날짜를 지정패턴으로 리턴한다
	 *  ex) addDays("20110701", 3, "yyyy/MM/dd") => 2011/07/04
	 * </pre>
	 * @param inputDate 입력 날짜("yyyyMMdd")
	 * @param addDay 더해줄 일자
	 * @param pattern 지정패턴
	 * @return String 지정형식의 결과 날짜
	 * @throws Exception
	 */
	public static String addDays(String inputDate, int addDay, String pattern) throws Exception{
		
		pattern = StringUtils.defaultIfEmpty(pattern, "yyyyMMdd");
		inputDate = StringUtils.defaultIfEmpty(inputDate, "19001010");
		SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		SimpleDateFormat outputFormatter = new SimpleDateFormat(pattern, Locale.KOREA);
		Date date = inputFormatter.parse(inputDate);

		// 하루는 (1/1000초*60초*60분*24시)
		date.setTime(date.getTime() + ((long)addDay * 1000 * 60 * 60 * 24));

		// Date형을 String형으로 
		return outputFormatter.format(date);
	}


	/**
	 * <pre>
	 * 입력날짜가 null 값이 아니고, 유효한 날짜이고, 지정패턴과 일치할 때, Date 객체 리턴
	 *  ex) strToDate("2011/02/22", "yyyy-MM-dd") => Exception 발생
	 * </pre>
	 * @param inputDate 입력 날짜
	 * @param pattern 지정패턴
	 * @return Date 객체
	 * @throws Exception
	 */
	public static Date strToDate(String inputDate, String pattern) throws Exception{
		// 파라메터 검사
		if ( inputDate == null ){
			throw new ParseException("date string to check is null", 0);
		}
		if ( pattern == null ){
			throw new ParseException("format string to check date is null", 0);
		}

		// 날짜 형식 지정
		SimpleDateFormat formatter = new SimpleDateFormat (pattern, Locale.KOREA);

		// 검사
		Date date = null;
		try{
			date = formatter.parse(inputDate);
		}catch(java.text.ParseException e){
			throw new ParseException(" wrong date:\"" + inputDate + "\" with format \"" + pattern + "\"", 0);
		}

		// 날짜 포멧이 틀린 경우
		if ( !formatter.format(date).equals(inputDate)){
			throw new ParseException("Out of bound date:\"" + inputDate + "\" with format \"" + pattern + "\"",0);
		}

		// 리턴
		return date;
	}

	/**
	 * <pre>
	 * 지정패턴에 일치할 때 두 날짜사이의 기간(일수) 리턴
	 *  ex)getBetweenDays("1998.02.24", "2011.07.14", "yyyy.MM.dd")
	 * </pre>
	 * @param from 기간시작날짜
	 * @param to 기간종료날짜
	 * @param pattern 지정패턴
	 * @return int 기간(일수)
	 * @throws Exception
	 */
	public static int getBetweenDays(String from, String to, String pattern) throws Exception {
		// 날짜 형식 지정
		//SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.KOREA);

		// 날짜 검사
		Date d1 = strToDate(from, pattern);
		Date d2 = strToDate(to, pattern);

		long duration = d2.getTime() - d1.getTime();

		return (int)( duration/(1000 * 60 * 60 * 24) );
	}


	/**
	 * <pre>
	 * 입력날짜를 지정패턴으로 변환후 리턴
	 *  ex)convertToPattern("20110715", "yyyy년 MM월 dd일") => 2011년 07월 15일
	 * </pre>
	 * @param inputDate 입력날짜("yyyyMMdd")
	 * @param pattern 지정패턴
	 * @return String 지정패턴으로 바뀐 날짜 문자열
	 * @throws Exception
	 */
	public static String convertToPattern(String inputDate, String pattern) throws Exception{
		// 날짜 형식 지정
		pattern = StringUtils.defaultIfEmpty(pattern, "yyyyMMdd");
		inputDate = StringUtils.defaultIfEmpty(inputDate, "19001010");
		SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		SimpleDateFormat outputFormatter = new SimpleDateFormat(pattern, Locale.KOREA);

		// 날짜 검사    
		Date targetDate = inputFormatter.parse(inputDate);

		return outputFormatter.format(targetDate);
	}


	/**
	 * <pre>
	 * 입력날짜를 지정패턴으로 변환후 리턴
	 *  ex)convertDateToPattern(new Date(), "yyyy-MM-dd, HH:mm:ss") => 2011-07-18, 17:35:28
	 * </pre>
	 * @param inputDate 입력날짜
	 * @param pattern 지정패턴
	 * @return String 지정패턴으로 바뀐 날짜 문자열
	 * @throws Exception
	 */
	public static String convertToPattern(Date inputDate, String pattern) throws Exception {
		pattern = StringUtils.defaultIfEmpty(pattern, "yyyyMMdd");	
		SimpleDateFormat formatter = new SimpleDateFormat (pattern,java.util.Locale.KOREA);
		return formatter.format(inputDate);
	}


	/**
	 * <pre>
	 * 입력날짜가 패턴과 일치하는지, 존재하는 날짜인지 체크
	 *  ex) boolean out = isValid("20110231", "yyyyMMdd") => false
	 *      boolean out = isValid("2011.02.22", "yyyy.MM.dd") => true
	 * </pre>
	 * 
	 * @param inputDate 입력날짜
	 * @param pattern 지정패턴
	 * @return boolean true 날짜 패턴이 맞고  존재하는 날짜일 때,
	 *                 false 날짜 패턴이 맞지 않거나 존재하지 않는 날짜일 때
	 * @throws Exception
	 */
	public static boolean isValid(String inputDate, String pattern) throws Exception {
		pattern = StringUtils.defaultIfEmpty(pattern, "yyyyMMdd");	
		SimpleDateFormat formatter = new SimpleDateFormat (pattern, Locale.KOREA);

		Date date = null;

		try{
			date = formatter.parse(inputDate);
		}catch(ParseException e){
			return false;
		}

		if ( ! formatter.format(date).equals(inputDate) )
			return false;

		return true;
	}


	/**
	 * <pre>
	 * 입력날짜 yyyyMMdd에서 입력구분자 추가후 리턴
	 *  ex) putDelimInDate("20110924", "/") => 2011/09/24
	 * </pre>
	 * @param inputDate 입력 날짜("yyyyMMdd")
	 * @param delim 입력구분자("/" or "-" ,etc..)
	 * @return String 구분자 추가한 날짜 문자열
	 * @throws Exception
	 */
	public static String putDelimInDate(String inputDate, String delim) throws Exception {

		String convert = new String();
		String date = inputDate.trim();
		if (date.equals("") || date.length() != 8) {
			return date;
		}
		convert = date.substring(0, 4) + delim + date.substring(4, 6) + delim + date.substring(6, 8);

		return convert;
	}

	/**
	 * <pre>
	 * 현재날짜시간을 지정패턴으로 변환후 리턴
	 *  ex) getCurrentDate("yyyy.MM.dd, HH:mm:ss")
	 * </pre>
	 * @param pattern 지정패턴
	 * @return String 지정패턴으로 바뀐 날짜 문자열
	 * @throws Exception
	 */
	public static String getCurrentDate(String pattern) throws Exception{
		pattern = StringUtils.defaultIfEmpty(pattern, "yyyyMMdd");	
		return new SimpleDateFormat(pattern, Locale.KOREA).format(new Date());
	}

	
	/**
	 * <pre>
	 * 입력일 yyyyMMdd 를 "yyyy년 MM월 dd일"로 리턴
	 *  ex) convertHanDate("20110719") => 2011년 7월 19일
	 * </pre>
	 * @param inputDate 입력 날짜("yyyyMMdd")
	 * @return String 한글 날짜 문자열
	 * @throws Exception
	 */
	public static String convertHanDate(String inputDate) throws Exception {


		String temp = null;
		int len = 0;

		if (inputDate == null) {
			return "";
		}

		len = inputDate.length();

		if (len != 8) {
			return inputDate;
		}

		temp = inputDate.substring(0, 4) + "년 " + Integer.parseInt(inputDate.substring(4, 6))
		+ "월 " + Integer.parseInt(inputDate.substring(6, 8)) + "일";

		return temp;
	}

	/**
	 * <pre>
	 * 입력일 yyyyMMdd 의 요일을 지정타입
	 * (1:한글약어, 2:한글, 3:영문약어, 4:영문)으로 리턴
	 *  ex) getDayInWeek("20110719", 2) => 화요일
	 * </pre>
	 * @param inputDate 입력날짜
	 * @param type 요일의 타입 - 1:한글약어, 2:한글, 3:영문약어, 4:영문
	 * @return String 지정타입의 요일 문자열
	 * @throws Exception
	 */
	public static String getDayInWeek(String inputDate, int type) throws Exception {

		SimpleDateFormat inputFormatter = new SimpleDateFormat ("yyyyMMdd", Locale.KOREA);

		Date targetDate = inputFormatter.parse(inputDate);
		String date = inputFormatter.format(targetDate);

		String[] week = null;

		DateFormatSymbols symbol = new DateFormatSymbols(Locale.KOREA);

		int orgYear = Integer.parseInt(date.substring(0, 4));
		int orgMon = Integer.parseInt(date.substring(4, 6)) - 1;
		int orgDay = Integer.parseInt(date.substring(6));

		//Calendar cal = GregorianCalendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.set(orgYear, orgMon, orgDay);

		// (1:한글약어, 2:한글, 3:영문약어, 4:영문)
		if (type == 1) week = new String[] {"", "일", "월", "화", "수", "목", "금", "토"};
		else if (type == 2) week = new String[] {"", "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		else if (type == 3) week = new String[] {"", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		else week = new String[] {"", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};

		symbol.setShortWeekdays(week);
		SimpleDateFormat sdf = new SimpleDateFormat("E", symbol); // 요일표시

		return sdf.format(cal.getTime());
	}

	/**
	 * <pre>
	 * 입력일을 지정패턴,입력TimeZone으로 변경후 리턴
	 *  ex) convertTimeZone("2011071910293000", "yyyyMMddHHmmss", "yyyy-MM-dd, HH:mm:ss", "")
	 * </pre>
	 * @param strSource 입력날짜 
	 * @param fromDatePattern 입력날짜의 패턴
	 * @param toDatePattern 지정패턴
	 * @param strTimeZone 변경할 TimeZone(""이면 변경 안함)
	 * @return String 변환된 날짜 문자열
	 * @throws Exception 
	 */
	public static String convertTimeZone(String strSource, String fromDatePattern, String toDatePattern, String strTimeZone) throws Exception {
		
		SimpleDateFormat simpledateformat = null;
		Date date = null;
		
		if (StringUtil.isEmpty2(strSource)) {
			return "";
		}
		
		String frmPtrn = fromDatePattern;
		if (StringUtil.isEmpty2(frmPtrn)) {
			frmPtrn = "yyyyMMddHHmmss"; // default값
		}

		String toPtrn = toDatePattern;
		if (StringUtil.isEmpty2(toPtrn)) {
			toPtrn = "yyyy-MM-dd HH:mm:ss"; // default값
		}

		simpledateformat = new SimpleDateFormat(frmPtrn);
		date = simpledateformat.parse(strSource);
		if (!strTimeZone.trim().equals("")) {
			simpledateformat.setTimeZone(TimeZone.getTimeZone(strTimeZone));
		}
		simpledateformat = new SimpleDateFormat(toPtrn);

		return simpledateformat.format(date);

	}

	/**
	 * <pre>
	 * 응용어플리케이션에서 고유값을 사용하기 위해 시스템에서17자리의 TIMESTAMP값을 구하는 기능
	 *  ex)
	 * getCurrentTimeStamp() => 현재 timestamp 출력
	 * </pre>
	 * @return String "yyyyMMddhhmmssSSS" 형태의 TimeStamp 값
	 * @throws Exception
	 */
	@SuppressWarnings("boxing")
	public static String getCurrentTimeStamp() throws Exception {

		String rtnStr = null;

		// 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
		String pattern = "yyyyMMddhhmmssSSS";
		pattern = StringUtils.defaultIfEmpty(pattern, "yyyyMMdd");	

		SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern,  Locale.KOREA);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		rtnStr = sdfCurrent.format(ts.getTime());

		return rtnStr;
	}

	public static String getTimeStamp() {
		return getTimeStamp(1);
	}

	/**
	 * <pre>
	 * TIMESTAMP값을 스트링형식으로 가져오는 기능
	 * 아규먼트에 따라서 형식을 바꾼다.
	 *  ex)
	 * 1: yyyy-MM-dd HH:mm:ss      → 2001-03-01 15:26:32
	 * 2: MMMM dd, yyyy HH:mm:ss z → Jun 03, 2001 15:26:32 GMT+09:00
	 * 3: MM/dd/yyyy               → 02/15/1999
	 * 4: yyyyMMdd                 → 19990215
	 * 5: HHmmss                   → 121241
	 * 6: dd MMM yyyy              → 15 Jan 1999
	 * 7: yyyyMMddHHmm             → 200101011010
	 * 8: yyyyMMddHHmmss           → 20010101101052
	 * 9: yyyyMMddhhmmssSSS
	 * 10: HHmmss
	 * 그 외의 값인 경우: E MMM dd HH:mm:ss z yyyy";// Wed Feb 03 15:26:32 GMT+09:00 1999
	 * </pre>
	 * 
	 * @return String 형태의 TimeStamp 값
	 * @throws Exception
	 */
	public static String getTimeStamp(int iMode) {
		
		String sFormat;
		
		switch (iMode) {
		case 1:
			sFormat = "yyyy-MM-dd HH:mm:ss";		// 2001-03-01 15:26:32
			break;
		case 2:
			sFormat = "MMMM dd, yyyy HH:mm:ss z";	// Jun 03, 2001 15:26:32 GMT+09:00
			break;
		case 3:
			sFormat = "MM/dd/yyyy";		// 02/15/1999
			break;
		case 4:
			sFormat = "yyyyMMdd";		// 19990215
			break;
		case 5:
			sFormat = "HHmmss";			// 121241
			break;
		case 6:
			sFormat = "dd MMM yyyy";	// 15 Jan 1999
			break;
		case 7:
			sFormat = "yyyyMMddHHmm";	//200101011010
			break;
		case 8:
			sFormat = "yyyyMMddHHmmss";	//20010101101052
			break;
		case 9:
			sFormat = "yyyyMMddhhmmssSSS";	// 파일업로드 용
			break;
		case 10:
			sFormat = "HHmmss";
			break;
		default:
			sFormat = "E MMM dd HH:mm:ss z yyyy";// Wed Feb 03 15:26:32 GMT+09:00 1999
			break;
		}

		Locale locale = new Locale("en", "EN");
		SimpleDateFormat formatter = new SimpleDateFormat(sFormat, locale);
		
		return formatter.format(new Date());
	}
}
