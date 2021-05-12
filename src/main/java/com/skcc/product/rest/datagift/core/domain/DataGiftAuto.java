package com.skcc.product.rest.datagift.core.domain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class DataGiftAuto implements DataGiftStrategy {
	DataGift dataGift;

	@Override
	public void sendDataGift() {
		// TODO Auto-generated method stub
		log.debug("T데이터 자동선물 전송 !!!");
	}
	
	public void registerDataGiftAuto() {
		log.debug("T데이터 자동선물 동록 !!!");
	}
	
	public void deleteDataGiftAuto() {
		log.debug("T데이터 자동선물 삭제 !!!");
	}

}
