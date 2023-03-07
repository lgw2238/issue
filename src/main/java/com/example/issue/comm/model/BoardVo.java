package com.example.issue.comm.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "board")
@DynamicInsert  /* @DynamicInsert    : Insert시 Null인 필드를 제외하기위해 사용 */
@DynamicUpdate  /* @DynamicUpdate : update시 Null인 필드를 제외하기위해 사용했음. */
public class BoardVo {

	@Id //Primary key의 컬럼인 것을 나타나주는 어노테이션 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "b_id") //대응하는 컬럼명 지정
	private Integer b_id;

	@Column(name = "b_writer", nullable = false, length = 100)
	private String b_writer;

	@Column(name = "b_title", nullable = false, length = 100)
	private String b_title;

	@Column(name = "b_contents", nullable = false, length = 512)
	private String b_contents;

	@CreationTimestamp
	@Column(name = "b_created_date")
	private LocalDateTime b_created_date;

	@UpdateTimestamp
	@Column(name = "b_update_date")
	private LocalDateTime b_update_date;



// ---Getter/Setter ---

}