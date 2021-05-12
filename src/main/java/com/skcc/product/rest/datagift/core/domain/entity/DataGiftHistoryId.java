package com.skcc.product.rest.datagift.core.domain.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class DataGiftHistoryId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long svcMgmtNum;
	private String opDtm;
}
