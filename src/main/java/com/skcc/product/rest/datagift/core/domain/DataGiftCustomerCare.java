package com.skcc.product.rest.datagift.core.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataGiftCustomerCare implements DataGiftStrategy {

	@Override
	public void sendDataGift() {
		// TODO Auto-generated method stub
		log.debug("고객센터 전용 데이터선물하기 10회 전송");
	}

}
