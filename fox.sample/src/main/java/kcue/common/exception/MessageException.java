package kcue.common.exception;
 
public class MessageException extends Exception { 
	 
	private static final long serialVersionUID = 1L;
	
	public String M_CODE = "-1";  //error message
	public String M_RTME = "...";  //return message 
	
	public MessageException(String strMessage) {
		super(strMessage); 
	}
	
	public MessageException(String strCode , String strMessage ) {
		super(strMessage); 
		M_CODE = strCode;
	}
	
	public static String getSQLErrorMessage(int error_code, String message) {
		// TODO Auto-generated method stub
		String error_msg = "";
		switch(error_code){
			case -8026:
				error_msg = "정의되지 않은 컬럼, 속성 또는 매개변수 이름이 발견되었습니다.";
				break; 
			case -10005:
				error_msg = "빈값을 허용하지 않습니다.";
				break; 
			case -10007:
				error_msg = "입력하려는 자료가 이미 존재합니다.";
				break; 
			default:
				error_msg = "["+error_code+"]데이타 오류가 발생하였습니다.";
				break;
		}
		return error_msg;
	}
	 
	
}
