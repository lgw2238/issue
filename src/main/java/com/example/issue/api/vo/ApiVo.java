package com.example.issue.api.vo;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Data
public class ApiVo {	 
	  private Header header;
	  private Body body;
	  
	  @Data
	  public static class Header {
	    private int resultCode;
	    private String resultMsg;
	    
	  }

	  @Data
	  public static class Body {
		  
	    /** 데이터 타입 */
	    private String dataType;
	    /** 한 페이지 결과 수 */
	    private int numOfRows;
	    /** 페이지 번호 */
	    private int pageNo;
	    /** 전체 결과 수 */
	    private int totalCount;
	    private Items items;
	    
	  }

	  @Data
	  public static class Items {
		  
	    private List<WeatherVo> item;
	    
	  }

}
