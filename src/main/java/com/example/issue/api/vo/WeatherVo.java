package com.example.issue.api.vo;

public class WeatherVo {

	  /** 발표일자 */
	  private String baseDate;

	  /** 발표시각 */
	  private String baseTime;

	  /** 예보일자 */
	  private String fcstDate;

	  /** 예보시각 */
	  private String fcstTime;

	  /** 자료구분문자 */
	  private CategoryType category;

	  /** 예보 값 */
	  private String fcstValue;

	  /** 예보지점 X 좌표 */
	  private float nx;

	  /** 예보지점 Y 좌표 */
	  private float ny;
	  
	  public String getBaseDate() {
		return baseDate;
	}

	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	public String getBaseTime() {
		return baseTime;
	}

	public void setBaseTime(String baseTime) {
		this.baseTime = baseTime;
	}

	public String getFcstDate() {
		return fcstDate;
	}

	public void setFcstDate(String fcstDate) {
		this.fcstDate = fcstDate;
	}

	public String getFcstTime() {
		return fcstTime;
	}

	public void setFcstTime(String fcstTime) {
		this.fcstTime = fcstTime;
	}

	public CategoryType getCategory() {
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

	public String getFcstValue() {
		return fcstValue;
	}

	public void setFcstValue(String fcstValue) {
		this.fcstValue = fcstValue;
	}

	public float getNx() {
		return nx;
	}

	public void setNx(float nx) {
		this.nx = nx;
	}

	public float getNy() {
		return ny;
	}

	public void setNy(float ny) {
		this.ny = ny;
	}

	public enum CategoryType {
	    POP("강수확률", "강수확률"),
	    PTY("강수형태", "코드값"),
	    R06("6시간 강수량", "범주 (1 mm)"),
	    S06("6시간 신적설", "범주 (1 cm)"),
	    SKY("하늘상태", "코드값"),
	    T3H("3시간 기온", "℃"),
	    TMN("아침 최저기온", "℃"),
	    TMX("낮 최저기온", "℃"),
	    WAV("파도", "M"),
	    T1H("기온", "℃"),
	    TMP("1시간 기온","℃"),
	    RN1("1시간 강수량", "mm"),
	    UUU("동서바람성분", "m/s"),
	    VVV("남북바람성분", "m/s"),
	    REH("습도", "%"),    
	    PCP("1시간 강수량", "mm"),    
	    VEC("풍향", "m/s"),
	    WSD("풍속", "1");

	    private String name;
	    private String unit;

	    private CategoryType(String name, String unit) {
	      this.name = name;
	      this.unit = unit;
	    }
	}
	  
	  
}

