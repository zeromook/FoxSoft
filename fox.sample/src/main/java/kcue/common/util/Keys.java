package kcue.common.util;
 
public class Keys {

	//Session   
    public static String USID_ID_KEY      		= "S_USID_ID";				// 사용자 ID
    public static String LGIN_ID_KEY      		= "S_LGIN_ID";				// 로그인 ID
    public static String USID_NM_KEY    		= "S_USID_NM";				// 사용자 명
    public static String USR_SE_KEY    		    = "S_USR_SE_CD";			// 사용자 구분
    public static String BLG_DIV_CD_KEY  		= "S_BLG_DIV_CD";			// 소속구분
    public static String MAC_IP_KEY    			= "S_MAC_IP";				// 접속 IP
    public static String USID_CRTFC_YN    		= "S_USID_CRTFC_YN";		// 본인인증유무
    public static String SCH_TEXT_KEY    		= "S_SCH_TEXT_KEY";	    	// 자주 찾는 검색어
    public static String CHLDRN_ID_KEY    		= "S_CHLDRN_ID";	    	// 자녀 ID
    public static String CNSLT_TCHER_AT    		= "S_CNSLT_TCHER_AT";		// 대입상담교사 여부
    public static String MAJOR_CNSLT_TCHER_AT   = "S_MAJOR_CNSLT_TCHER_AT";	// 전공상담교사 여부
    public static String MNTRNG_TCHER_AT    	= "S_MNTRNG_TCHER_AT";		// 모니터링검증단 여부
    public static String STDR_SCH_YEAR    		= "S_STDR_SCH_YEAR";		// 전공상담교사 여부
    public static String COMPUT_AT    		    = "S_COMPUT_AT";			// 산출식검증단 여부
    public static String PW_CNG_YN				= "S_PW_CNG_YN";			// 사용자 비밀번호(6개월) 변경여부
    public static String SNS_LOGIN_YN			= "S_SNS_LOGIN_YN";			// SNS 로그인 여부 (비번변경체크안함, 탈퇴시 비번묻지않음)
    
    public static String MENU_AUTH_KEY 			= "S_MENU_AUTH";			// 메뉴별 권한 리스트
    public static String MENU_AUTH_JSON_KEY 	= "S_MENU_AUTH_JSON";		// 메뉴별 권한 리스트
    public static String QUICK_MENU_AUTH_KEY 	= "S_QUICK_MENU_AUTH";		// 메뉴별 권한 리스트 퀵 메뉴    
    public static String OPEN_MENU_ID_KEY 		= "S_OPEN_MENU_ID";			// 현재 열려있는 메뉴
    public static String OPEN_MENU_GRP_KEY 		= "S_OPEN_MENU_GRP";		// 현재 열려있는 메뉴 그룹
    public static String PROCESS_CODE_KEY 		= "S_OPEN_MENU_GRP";		// 현재 실행되는 CRUD 정보
    public static String TEL_MAPING_AGRE_AT		= "S_TEL_MAPING_AGRE_AT";	// 전화매핑 동의여부
    
    public static String PRE_URL		= "S_PRE_URL";	// 로그인 페이지 자동으로 이동 시 이전 페이지 정보
    public static String UNIV_CD		= "S_UNIV_CD";	// 비대면 온라인 상담 중 로그인 페이지 자동으로 이동 시 대학코드 정보
    public static String AREA_CD		= "S_AREA_CD";	// 로그인 페이지 자동으로 이동 시 이전 페이지 정보
}
