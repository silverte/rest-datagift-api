package com.skcc.product.rest.datagift.core.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.skcc.product.rest.datagift.core.domain.enums.ProductGroup;
import com.skcc.product.rest.datagift.core.domain.vo.DataGiftHistoryCount;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftQueryRepository;

public class DataGift {
	private DataGiftStrategy delegate;
	private DonorServiceInfo serviceInfo;
	private ProductRule rule;
	
	@Autowired
	IDataGiftQueryRepository dataGiftQueryRepository;
		
	public DataGift(DonorServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
		this.rule = new ProductRule();
	}
	
	public void setDataGiftType(DataGiftStrategy type) {
		this.delegate = type;
	}
	
	public void sendDataGift() {
		this.delegate.sendDataGift();
	}
	
	protected ProductGroup getProductGroup() {
		return rule.getProductGroup(serviceInfo.svcMgmtNum, serviceInfo.feeProdId);
	}
	
	public DataGiftHistoryCount getDataGiftHistoryCount() {
		DataGiftHistoryCount count = new DataGiftHistoryCount();
		
		/*선물 가능 기준조회*/
		DataGiftLimit.getSendCountLimit(this.getProductGroup());
		
		/*당월 선물 이력조회 */
		QueryResults<Tuple> queryResults = dataGiftQueryRepository.getMonthDataGiftSendHistoryCount(Long.valueOf(serviceInfo.svcMgmtNum), "202105");
		List<Tuple> list = queryResults.getResults();
		
		/* VO setup */
		count.setGeneralCount(DataGiftLimit.generalCount);
		count.setExtraCount(DataGiftLimit.extraCount);
		/*/
		Map<String,Integer> returnMap = new HashMap();
		for (Tuple tuple : list) { 
			return tuple.get(0, String.class), tuple.get(1, Integer.class));
		}
		*/
		//count.setSentGeneralCount(list.);
		//settuple.get(0, String.class)
		return count;
	}

}
