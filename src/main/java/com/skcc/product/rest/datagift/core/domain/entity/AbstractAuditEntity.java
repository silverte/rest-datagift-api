package com.skcc.product.rest.datagift.core.domain.entity;

import java.sql.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;


@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@Getter
public class AbstractAuditEntity {
	
	@LastModifiedBy
	private String auditId;
	
	@LastModifiedDate
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date auditDtm;
}
