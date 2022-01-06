package kcue.common.result;

import java.io.Serializable;
import java.util.Locale;

import kcue.common.util.StringUtil;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

/**
* Json Transaction 결과를 전달하는 공통 VO
* @author 장진홍
* @since 2015.01.06
* @version 1.0
* @see
*
* <pre>
* == 개정이력(Modification   Information) ==
*
* 수정일 수정자 수정내용
* ------- --------   ---------------------------
* 2015.01.12 장진홍 최초 생성
*
* </pre>
*/
@SuppressWarnings("serial")
public class KcueResultVO implements Serializable {

	private String resultCode = "";
	private String resultMessage = "";
	
	/**
	 * 결과 코드를 리턴한다.
	 * 성공 : SUCCESS 실퍠: ERROR
	 * @return
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * 결과 코드를 담는다.
	 * 성공 : SUCCESS 실퍠: ERROR
	 * @param resultCode
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	/**
	 * 실패시 트랜잭션 처리 결과를전달한다.
	 * @return
	 */
	public String getResultMessage() {
		return resultMessage;
	}
	/**
	 * 실패시 트랜잭션 처리 결과를 담는다.
	 * @param resultMessage
	 */
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	

    public static final String SAVE_SUCCESS		= "success.common.insert";
    public static final String CREATE_SUCCESS	= "success.common.insert";
	public static final String UPDATE_SUCCESS	= "success.common.update";
    public static final String DELETE_SUCCESS		= "success.common.delete";

    
	public void setResultSuccess(MessageSource messageSource, String strCommand) {
		String msg	= "";
		
		if(StringUtil.isEmpty(strCommand)) {
			msg	= "";
		} else if(strCommand.equals("C")) {
			msg = this.CREATE_SUCCESS;
		} else if(strCommand.equals("R")) {
			msg = null;
		} else if(strCommand.equals("U")) {
			msg = this.UPDATE_SUCCESS;
		} else if(strCommand.equals("D")) {
			msg = this.DELETE_SUCCESS;
		} else {
			msg = strCommand;
		}
		
		setResult(messageSource, msg);
	}
	
	/**
	 * 실패/경고에 따른 메세지/코드 세팅_구현
	 * @param messageSource
	 * @param model
	 * @param strCommand
	 */
	public void setResultWarning(MessageSource messageSource, String strMessage) {
		
		setResult(messageSource, strMessage);
	}

	public void setResult(MessageSource messageSource, String msg) {
		if(msg != null && !"".equals(msg)) {
			try {
				setResultMessage(messageSource.getMessage(msg, null, Locale.getDefault()));
			} catch (NoSuchMessageException nsme) {
				setResultMessage(messageSource.getMessage("fail.common.msg", null, Locale.getDefault()));
			} catch (Exception e) {
				setResultMessage(messageSource.getMessage("fail.common.msg", null, Locale.getDefault()));
			}
		}
	}
}
