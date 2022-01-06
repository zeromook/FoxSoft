/**
 * 
 */
package kcue.common.filter;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 크로스 사이트 스크립팅(XSS)공격방지 HttpServletRequestWrapper
 * 
 * @author 장진홍
 * @since 2015.01.09
 * @version 1.0
 * @see
 * 
 * <pre>
 * == 개정이력(Modification   Information) ==
 * 
 * 수정일 수정자 수정내용
 * ------- --------   ---------------------------
 * 2015.01.09 장진홍 최초 생성
 * 
 * </pre>
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper {
	private static Pattern[] patterns = new Pattern[] {
			// Script fragments
			Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
			// src='...'
			Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL),
			Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL),
			// lonely script tags
			Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
			Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL),
			// eval(...)
			Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL),
			// expression(...)
			Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL),
			// javascript:...
			Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
			// vbscript:...
			Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
			// onload(...)=...
			Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL) };

	public XSSRequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
	}

	@Override
	public String[] getParameterValues(String parameter) {
		final String[] values = super.getParameterValues(parameter);

		if (values == null) {
			return null;
		}

		final int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = stripXSS(values[i]);
		}

		return encodedValues;
	}

	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		return stripXSS(value);
	}

	@Override
	public String getHeader(String name) {
		final String value = super.getHeader(name);
		return stripXSS(value);
	}

	private String stripXSS(final String value) {
		String strValue = value;
		if (strValue != null) {
			// NOTE: It's highly recommended to use the ESAPI library and
			// uncomment the following line to
			// avoid encoded attacks.
			// value = ESAPI.encoder().canonicalize(value);

			// Avoid null characters
			strValue = strValue.replaceAll("\0", "");

			// Remove all sections that match a pattern
			for (Pattern scriptPattern : patterns) {
				strValue = scriptPattern.matcher(strValue).replaceAll("");
			}

			// Rexpert 파라미터 전달시 테그 사용으로 막음
			strValue = strValue.replaceAll("#", "&#35;").replaceAll("&", "&#38;").replaceAll("&#38;#35;", "&#35;");
			strValue = strValue.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
			strValue = strValue.replaceAll("\\(", "&#40;").replaceAll("\\)","&#41;");
			strValue = strValue.replaceAll("\"", "&#34;").replaceAll("'", "&#39;");
		}
		return strValue;
	}
}
