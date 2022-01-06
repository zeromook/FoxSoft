/*
 * 대학입학정보포털 사이트
 * 
 * 한국대학교육협의회
 * 폭스소프트 개발팀
 */
package kcue.common.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;


/**  
 * @Class Name : BrowserUtil.java
 * @Description : BrowserUtil Class
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
public class BrowserUtil {

	/**
	 * <pre>
	 * 브라우저 구분 얻기.
	 * </pre>
	 * @param HttpServletRequest
	 * @return String 
	 * @throws Exception
	 */
	private static String getBrowser(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");      
        
        if (header.indexOf("MSIE") > -1) {
            return "MSIE";
        } else if (header.indexOf("Chrome") > -1) {
            return "Chrome";
        } else if (header.indexOf("Opera") > -1) {
            return "Opera";
        } else if (header.indexOf("Mozilla") > -1) {
        	return "MSIE";
        }
        return "Firefox";
    }

    
	/**
	 * <pre>
	 * Disposition 지정하기.
	 * </pre>
	 * @param filename 파일명
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return void
	 * @throws Exception
	 */
    public static void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String browser = getBrowser(request);
	
		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;
		
		if (browser.equals("MSIE")) {
		    encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
		    encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Opera")) {
		    encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
		    StringBuffer sb = new StringBuffer();
		    for (int i = 0; i < filename.length(); i++) {
			char c = filename.charAt(i);
			if (c > '~') {
			    sb.append(URLEncoder.encode("" + c, "UTF-8"));
			} else {
			    sb.append(c);
			}
		    }
		    encodedFilename = sb.toString();
		} else {
		    //throw new RuntimeException("Not supported browser");
		    throw new IOException("Not supported browser");
		}
		
		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
	
		if ("Opera".equals(browser)){
		    response.setContentType("application/octet-stream;charset=UTF-8");
		}
    }

	/**
	 * <pre>
	 * 쿠키세팅하기
	 * </pre>
	 * 
	 * @param HttpServletRequest
	 * @return String
	 * @throws Exception
	 */
	public static void addCookieValue(HttpServletResponse response, String cookieName, String cookieValue, int maxAge) {

		Cookie cookie = new Cookie(cookieName, StringUtil.nchk(cookieValue));
		cookie.setMaxAge(maxAge);
    	cookie.setPath("/");
//    	cookie.setSecure(true);		//SSL 적용후 반영
		response.addCookie(cookie);
	}
	
	/**
	 * <pre>
	 * 쿠키값읽기
	 * </pre>
	 * 
	 * @param HttpServletRequest
	 * @return String
	 * @throws Exception
	 */
	public static String getCookieValue(HttpServletRequest request, String cookieName) {
		String cookieValue = null;
		Cookie[] cookies = request.getCookies();
		
		if (cookies == null) return null;
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieName)) {
				cookieValue = cookie.getValue();
				break;
			}
		}
		return cookieValue;
	}
	
	private static String getBrowserVersion(String strBrowser, String browser) {
		String browserRemoved = strBrowser.replace(browser, "").replace("/", "");
		return browserRemoved.trim();
	}
	
	private static final String BROWSER_MSIE	= "MSIE";
	private static final String BROWSER_CHROME	= "Chrome";
	private static final String BROWSER_FIREFOX = "Firefox";
	private static final String BROWSER_OPERA	= "Opera";
	private static final String BROWSER_SAFARI	= "Safari";
	private static final String BROWSER_OTHER	= "Other";

	private static final String OS_WINDOWS		= "Windows";
	private static final String OS_IPAD			= "iPad";
	private static final String OS_IPHONE		= "iPhone";
	private static final String OS_ANDROID		= "Android";
	private static final String OS_LINUX		= "Linux";
	private static final String OS_MACOS		= "MacOS";
	private static final String OS_OTHER		= "Other";
	
	public static HashMap<String, String> getClientInfo(HttpServletRequest request) {
		
		HashMap<String, String> hm = new HashMap<String, String>();
		String strBrowser			= "";
		String strBrowserName		= "";
		String strBrowserVersion	= "";
		String strOSName	= "";

		String header = request.getHeader("User-Agent");
		hm.put("user_agent", header);

		if (header.indexOf(BROWSER_MSIE) > -1) {
			strBrowserName = BROWSER_MSIE;
		} else if (header.indexOf(BROWSER_CHROME) > -1) {
			strBrowserName = BROWSER_CHROME;
		} else if (header.indexOf(BROWSER_FIREFOX) > -1) {
			strBrowserName = BROWSER_FIREFOX;
		} else if (header.indexOf(BROWSER_OPERA) > -1) {
			strBrowserName = BROWSER_OPERA;
		} else if (header.indexOf(BROWSER_SAFARI) > -1) {
			strBrowserName = BROWSER_SAFARI;
		} else {
			strBrowserName = BROWSER_OTHER;
		}

		if (BROWSER_OTHER.equals(strBrowserName)) {
			strBrowserVersion = "";
		} else {
			//int idx = header.indexOf("MSIE");
			int idx = header.indexOf(strBrowserName);
			int idxStart = idx + strBrowserName.length() + 1;
			idxStart = Math.min(idxStart, header.length());
			
			int idxEnd = header.length();
			if (header.indexOf(";", idxStart) > 0 && header.indexOf(" ", idxStart) > 0) {
				idxEnd = Math.min(header.indexOf(";", idxStart), header.indexOf(" ", idxStart));
			} else if (header.indexOf(";", idxStart) > 0) {
				idxEnd = header.indexOf(";", idxStart);
			} else if (header.indexOf(" ", idxStart) > 0) {
				idxEnd = header.indexOf(" ", idxStart);
			}
			
			strBrowser = header.substring(idx, idxEnd);
			strBrowserVersion = getBrowserVersion(strBrowser, strBrowserName);
		}
		
		hm.put("browser_name", strBrowserName);
		hm.put("browser_version", strBrowserVersion);

		if (header.indexOf(OS_WINDOWS) > -1) {
			strOSName = OS_WINDOWS;
		} else if (header.indexOf(OS_IPAD) > -1) {
			strOSName = OS_IPAD;
		} else if (header.indexOf(OS_IPHONE) > -1) {
			strOSName = OS_IPHONE;
		} else if (header.indexOf(OS_ANDROID) > -1) {
			strOSName = OS_ANDROID;
		} else if (header.indexOf(OS_LINUX) > -1) {
			strOSName = OS_LINUX;
		} else if (header.indexOf(OS_MACOS) > -1) {
			strOSName = OS_MACOS;
		} else {
			strOSName = OS_OTHER;
		}
		hm.put("os_name", strOSName);

		return hm;
	}
	
    /**
     * Key 에 해당하는 쿠기 삭제
     * 
     * @param request
     * @param response
     */
    public static void expireCookie(String keyName, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookies[] = request.getCookies();

        if(cookies != null){
            for (Cookie thisCookie : cookies) {
                String _cName = thisCookie.getName();
                if (StringUtils.equals(_cName, keyName)) {
                    BrowserUtil.addCookieValue(response, _cName, "", 0);
                }
            }
        }
    }
}
