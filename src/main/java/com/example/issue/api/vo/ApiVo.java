package com.example.issue.api.vo;

import java.util.List;

import lombok.Data;

public class ApiVo {	 
	  private Header header;
	  public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	private Body body;
	  
	  
	  public static class Header {
	    private int resultCode;
	    private String resultMsg;
		public int getResultCode() {
			return resultCode;
		}
		public void setResultCode(int resultCode) {
			this.resultCode = resultCode;
		}
		public String getResultMsg() {
			return resultMsg;
		}
		public void setResultMsg(String resultMsg) {
			this.resultMsg = resultMsg;
		}
	    
	    
	  }

	  
	  public static class Body {
		  
	    public String getDataType() {
			return dataType;
		}
		public void setDataType(String dataType) {
			this.dataType = dataType;
		}
		public int getNumOfRows() {
			return numOfRows;
		}
		public void setNumOfRows(int numOfRows) {
			this.numOfRows = numOfRows;
		}
		public int getPageNo() {
			return pageNo;
		}
		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}
		public int getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}
		public Items getItems() {
			return items;
		}
		public void setItems(Items items) {
			this.items = items;
		}
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
