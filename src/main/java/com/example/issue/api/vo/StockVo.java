package com.example.issue.api.vo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Data
public class StockVo {
	
	/* 통화 국가 */
	private String curName;
	/* 통화 이름 */
	private String billName;
	/* 송금 보낼 때 가격 */
	private String sendTax;
	/* 송금 받을 때 가격*/
	private String receiveTax;
	/* 중간 가격 */
	private String standatdTax;
	
	/* crawling stock title */
	private String stockTitle;
	/* crawling response body data */
	private String stockBody;
	/* crawling request parameter */
	private String stockType;
}
