package com.skcc.product.rest.datagift.core.domain;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class DonorServiceInfo {
	String svcNum;
	String svcMgmtNum;
	String feeProdId;
	String custNum;
	String svcScrbDt;
	
	public DonorServiceInfo(String svcMgmtNum) {
		this.svcMgmtNum = svcMgmtNum;
		getServiceInfo();
	}
	
	private void getServiceInfo () {
		
		log.debug("service info SQL execute !!!");
		this.svcNum = "01053060424";
		this.feeProdId = "NA00006404";
		this.custNum = "8234511111";
		this.svcScrbDt = "20061024";
		log.debug(this.toString());
	}
}
