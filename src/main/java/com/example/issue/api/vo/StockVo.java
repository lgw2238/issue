package com.example.issue.api.vo;

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
	
	
	
	/* 환율 정보 full String*/
	private String exchangeBody;
	
	/* 통합지수 정보 full String*/
	private String jisuDataBody;
	
	/* jisu img src Link */
	private String imgLink;

	public String getCurName() {
		return curName;
	}

	public void setCurName(String curName) {
		this.curName = curName;
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public String getSendTax() {
		return sendTax;
	}

	public void setSendTax(String sendTax) {
		this.sendTax = sendTax;
	}

	public String getReceiveTax() {
		return receiveTax;
	}

	public void setReceiveTax(String receiveTax) {
		this.receiveTax = receiveTax;
	}

	public String getStandatdTax() {
		return standatdTax;
	}

	public void setStandatdTax(String standatdTax) {
		this.standatdTax = standatdTax;
	}

	public String getStockTitle() {
		return stockTitle;
	}

	public void setStockTitle(String stockTitle) {
		this.stockTitle = stockTitle;
	}

	public String getStockBody() {
		return stockBody;
	}

	public void setStockBody(String stockBody) {
		this.stockBody = stockBody;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public String getExchangeBody() {
		return exchangeBody;
	}

	public void setExchangeBody(String exchangeBody) {
		this.exchangeBody = exchangeBody;
	}

	public String getJisuDataBody() {
		return jisuDataBody;
	}

	public void setJisuDataBody(String jisuDataBody) {
		this.jisuDataBody = jisuDataBody;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
	
}
