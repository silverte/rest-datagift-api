package com.skcc.product.rest.datagift.core.domain;

import com.skcc.product.rest.datagift.core.domain.enums.ProductGroup;

public class DataGift {
	private DataGiftStrategy delegate;
	private DonorServiceInfo serviceInfo;
	private ProductRule rule;
	private DataGiftLimit limit;
	private DataGiftSendHistrory history;
	
	public DataGift(DonorServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
		this.rule = new ProductRule();
		this.limit = new DataGiftLimit();
		this.history = new DataGiftSendHistrory();
	}
	
	public void setDataGiftType(DataGiftStrategy type) {
		this.delegate = type;
	}
	
	public void sendDataGift() {
		this.delegate.sendDataGift();
	}
	
	public ProductGroup getProductGroup() {
		return rule.getProductGroup(serviceInfo.svcMgmtNum, serviceInfo.feeProdId);
	}
	
	public DataGiftLimit getSendCountLimit(ProductGroup productGroup) {
		return limit.getSendCountLimit(productGroup);
	}
	
	public Data

}
