package kcue.common;

import java.io.Serializable;
import java.util.Map;

import kcue.common.util.StringUtil;

import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.ui.ModelMap;

import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name : KcueDefaultVO.java
 * @Description : Kcue Default VO class
 * @Modification Information
 *
 * @author 김현욱
 * @since 2014.10.2
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class KcueDefaultVO implements Serializable {

	/** serialize id */
	private static final long serialVersionUID = 1L;
	
	/** 기본검색조건 */
	private String searchDefaultField = "";

	/** 추가검색조건 */
	private String searchExtField = "";

	/** 두번쩨 추가검색조건 */
	private String searchSecExtField = "";	
	
	/** 세번쩨 추가검색조건 */
	private String searchThrExtField = "";
	
	/** 네번쩨 추가검색조건 */
	private String searchForExtField = "";
	
	/** 다섯번쩨 추가검색조건 */
	private String searchFivExtField = "";
	
	/** 여섯번쩨 추가검색조건 */
	private String searchSixExtField = "";
	
	/** 일곱번쩨 추가검색조건 */
	private String searchSevExtField = "";

	/** 여덟번쩨 추가검색조건 */
	private String searchEigExtField = "";

	/** 아홉번쩨 추가검색조건 */
	private String searchNineExtField = "";
	
	/** 검색Keyword 조건*/
    private String searchFindKeyword = "";	
    
	/** 검색Keyword */
    private String searchKeyword = "";    
    
	/** 검색일자 구분 조건*/
    private String searchFindDate = "";    
    
	/** 검색 시작일자 */
    private String searchStDt = "";
    
	/** 검색 종료일자 */
    private String searchEndDt = "";  
    
    /** 검색사용여부 */
    private String searchUseYn = "";
    

    /***************************************************/
	/*                    Link Param                   */
	/***************************************************/
	/** 기본 Link Param */
	private String linkParamDefaultField = "";

	/** 추가 Link Param */
	private String linkParamField = "";

	/** 두번쩨 추가 Link Param */
	private String linkParamSecField = "";	
	
	/** 세번쩨 추가 Link Param */
	private String linkParamThrField = "";
	
	/** 네번쩨 추가 Link Param */
	private String linkParamForField = "";
	
	/** 다섯번쩨 추가 Link Param */
	private String linkParamFivField = "";
	
	/** 여섯번쩨 추가 Link Param */
	private String linkParamSixField = "";
	
	/** 일곱번쩨 추가 Link Param */
	private String linkParamSevField = "";
	
    
    
    /** 현재페이지 */
    private int pageIndex = 1;
    
    /** 페이지갯수 */
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
    /** 메뉴ID*/
    private String p_menu_id = "";
    
    public String getP_menu_id() {
		return p_menu_id;
	}
	public void setP_menu_id(String p_menu_id) {
		this.p_menu_id = p_menu_id;
	}
	
	/*********************** 첨부파일 ***************************/
	public static final String DELETE_FILE_LIST = "delete_file_list";
    protected String atch_file_id = "";
    protected String file_sn = "";
    protected String orignl_file_nm = "";
	protected Map<String, MultipartFile> files;
	private String[] delete_file_list;     
            
	
	
	/**
	 * @return the searchEigExtField
	 */
	public String getSearchEigExtField() {
		return searchEigExtField;
	}
	/**
	 * @param searchEigExtField the searchEigExtField to set
	 */
	public void setSearchEigExtField(String searchEigExtField) {
		this.searchEigExtField = searchEigExtField;
	}
	/**
	 * @return the searchNineExtField
	 */
	public String getSearchNineExtField() {
		return searchNineExtField;
	}
	/**
	 * @param searchNineExtField the searchNineExtField to set
	 */
	public void setSearchNineExtField(String searchNineExtField) {
		this.searchNineExtField = searchNineExtField;
	}
	
	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}
		
    public String getSearchDefaultField() {
		return searchDefaultField;
	}

	public void setSearchDefaultField(String searchDefaultField) {
		this.searchDefaultField = searchDefaultField;
	}

	public String getSearchExtField() {
		return searchExtField;
	}

	public void setSearchExtField(String searchExtField) {
		this.searchExtField = searchExtField;
	}

	public String getSearchSecExtField() {
		return searchSecExtField;
	}

	public void setSearchSecExtField(String searchSecExtField) {
		this.searchSecExtField = searchSecExtField;
	}

	public String getSearchThrExtField() {
		return searchThrExtField;
	}

	public void setSearchThrExtField(String searchThrExtField) {
		this.searchThrExtField = searchThrExtField;
	}

	public String getSearchForExtField() {
		return searchForExtField;
	}

	public void setSearchForExtField(String searchForExtField) {
		this.searchForExtField = searchForExtField;
	}

	public String getSearchFivExtField() {
		return searchFivExtField;
	}

	public void setSearchFivExtField(String searchFivExtField) {
		this.searchFivExtField = searchFivExtField;
	}

	public String getSearchSixExtField() {
		return searchSixExtField;
	}

	public void setSearchSixExtField(String searchSixExtField) {
		this.searchSixExtField = searchSixExtField;
	}

	public String getSearchSevExtField() {
		return searchSevExtField;
	}

	public void setSearchSevExtField(String searchSevExtField) {
		this.searchSevExtField = searchSevExtField;
	}

	public String getSearchFindKeyword() {
		return searchFindKeyword;
	}

	public void setSearchFindKeyword(String searchFindKeyword) {
		this.searchFindKeyword = searchFindKeyword;
	}

	public String getSearchFindDate() {
		return searchFindDate;
	}

	public void setSearchFindDate(String searchFindDate) {
		this.searchFindDate = searchFindDate;
	}

	public String getSearchStDt() {
		return searchStDt;
	}

	public void setSearchStDt(String searchStDt) {
		this.searchStDt = searchStDt;
	}

	public String getSearchEndDt() {
		return searchEndDt;
	}

	public void setSearchEndDt(String searchEndDt) {
		this.searchEndDt = searchEndDt;
	}

	public String getSearchKeyword() {
        return StringUtil.getHtmlStrCnvr(searchKeyword);
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = StringUtil.getHtmlStrCnvr(searchKeyword);
    }

    public String getSearchUseYn() {
        return searchUseYn;
    }

    public void setSearchUseYn(String searchUseYn) {
        this.searchUseYn = searchUseYn;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageUnit() {
        return pageUnit;
    }

    public void setPageUnit(int pageUnit) {
        this.pageUnit = pageUnit;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
	public void setPageInfo(EgovPropertyService propertiesService, ModelMap model, int totCnt) {
		int iPageUnit = propertiesService.getInt("pageUnit");
		int iPageSize = propertiesService.getInt("pageSize");
		int iPageIndex = propertiesService.getInt("pageIndex");
		setPageInfo(propertiesService, model, totCnt, iPageUnit, iPageSize, iPageIndex);
	}
	
	public void setPageInfo(EgovPropertyService propertiesService, ModelMap model, int totCnt, int pageUnit, int pageSize, int pageIndex) {
    	int firstIndex = 0;
    	int lastIndex = 0;
    	firstIndex = (pageIndex*pageSize)-pageSize;
    	lastIndex = pageIndex*pageSize;
    	if(lastIndex >= totCnt){
    		lastIndex = totCnt;
    	}else{
    		lastIndex = pageIndex*pageSize;
    	}
		this.setFirstIndex(firstIndex);
		this.setLastIndex(lastIndex);
   }

	public String getAtch_file_id() {
		return atch_file_id;
	}

	public void setAtch_file_id(String atch_file_id) {
		this.atch_file_id = atch_file_id;
	}

	public String getFile_sn() {
		return file_sn;
	}

	public void setFile_sn(String file_sn) {
		this.file_sn = file_sn;
	}

	public String getOrignl_file_nm() {
		return orignl_file_nm;
	}

	public void setOrignl_file_nm(String orignl_file_nm) {
		this.orignl_file_nm = orignl_file_nm;
	}

	public Map<String, MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(Map<String, MultipartFile> files) {
		this.files = files;
	}

	public String[] getDelete_file_list() {
		String[] strArg = null;
		if(this.delete_file_list != null){
			strArg = new String[delete_file_list.length];
			for(int i = 0 ; i < delete_file_list.length ; i++){
				strArg[i] = this.delete_file_list[i];
			}
		}
		return strArg;
	}

	public void setDelete_file_list(String[] delete_file_list) {
		if(delete_file_list != null){
			this.delete_file_list = new String[delete_file_list.length];
			for(int i = 0; i < delete_file_list.length; ++i){
				this.delete_file_list[i] = delete_file_list[i];
			}	
		}

	}

	public String getDELETE_FILE_LIST() {
		return DELETE_FILE_LIST;
	}
	
	/***************************************************/
	/*                    Link Param                   */
	/***************************************************/
	public String getLinkParamDefaultField() {
		return linkParamDefaultField;
	}

	public void setLinkParamDefaultField(String linkParamDefaultField) {
		this.linkParamDefaultField = linkParamDefaultField;
	}

	public String getLinkParamField() {
		return linkParamField;
	}

	public void setLinkParamField(String linkParamField) {
		this.linkParamField = linkParamField;
	}

	public String getLinkParamSecField() {
		return linkParamSecField;
	}

	public void setLinkParamSecField(String linkParamSecField) {
		this.linkParamSecField = linkParamSecField;
	}

	public String getLinkParamThrField() {
		return linkParamThrField;
	}

	public void setLinkParamThrField(String linkParamThrField) {
		this.linkParamThrField = linkParamThrField;
	}

	public String getLinkParamForField() {
		return linkParamForField;
	}

	public void setLinkParamForField(String linkParamForField) {
		this.linkParamForField = linkParamForField;
	}

	public String getLinkParamFivField() {
		return linkParamFivField;
	}

	public void setLinkParamFivField(String linkParamFivField) {
		this.linkParamFivField = linkParamFivField;
	}

	public String getLinkParamSixField() {
		return linkParamSixField;
	}

	public void setLinkParamSixField(String linkParamSixField) {
		this.linkParamSixField = linkParamSixField;
	}

	public String getLinkParamSevField() {
		return linkParamSevField;
	}

	public void setLinkParamSevField(String linkParamSevField) {
		this.linkParamSevField = linkParamSevField;
	}

}
