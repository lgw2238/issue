package com.example.issue;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class IssueApplication extends SpringBootServletInitializer {
	
	/* localtime area 주입 - Asia/Seoul */
    @PostConstruct
    public void started() {
      // timezone UTC 셋팅
      TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }
    
	public static void main(String[] args) {
		SpringApplication.run(IssueApplication.class, args);
	}
	
	/* json 파일 UTF-8 변환필터 */
	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}
	
	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(IssueApplication.class);
	  }
}
