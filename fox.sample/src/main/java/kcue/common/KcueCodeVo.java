package kcue.common;

import java.io.Serializable;


/**
 * @Class Name : KcueCodeVo.java
 * @Description : KcueCodeVo VO class
 * @Modification Information
 *
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class KcueCodeVo implements Serializable{

	/** default serial version ID */
	private static final long serialVersionUID = 1L;
	/** 코드 */
	private String codeStr;
	/** 코드명 */
	private String codeName;
	/** 코드그룹 */
	private String codeGrp;
	/** 기본 검색필드 */
	private String searchDefaultField;
	/** 검색필드 */
	private String searchSecExtField;
	/**
	 * @return the codeStr
	 */
	public String getCodeStr() {
		return codeStr;
	}
	/**
	 * @param codeStr the codeStr to set
	 */
	public void setCodeStr(String codeStr) {
		this.codeStr = codeStr;
	}
	/**
	 * @return the codeName
	 */
	public String getCodeName() {
		return codeName;
	}
	/**
	 * @param codeName the codeName to set
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	/**
	 * @return the codeGrp
	 */
	public String getCodeGrp() {
		return codeGrp;
	}
	/**
	 * @param codeGrp the codeGrp to set
	 */
	public void setCodeGrp(String codeGrp) {
		this.codeGrp = codeGrp;
	}
	/**
	 * @return the searchDefaultField
	 */
	public String getSearchDefaultField() {
		return searchDefaultField;
	}
	/**
	 * @param searchDefaultField the searchDefaultField to set
	 */
	public void setSearchDefaultField(String searchDefaultField) {
		this.searchDefaultField = searchDefaultField;
	}
	/**
	 * @return the searchSecExtField
	 */
	public String getSearchSecExtField() {
		return searchSecExtField;
	}
	/**
	 * @param searchSecExtField the searchSecExtField to set
	 */
	public void setSearchSecExtField(String searchSecExtField) {
		this.searchSecExtField = searchSecExtField;
	}
}
