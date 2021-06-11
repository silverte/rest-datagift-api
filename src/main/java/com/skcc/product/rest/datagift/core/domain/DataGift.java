package com.skcc.product.rest.datagift.core.domain;


import org.springframework.beans.factory.annotation.Autowired;

import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistory;
import com.skcc.product.rest.datagift.core.domain.enums.ProductGroup;
import com.skcc.product.rest.datagift.core.domain.vo.DataGiftHistoryCount;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftHistoryCommmandRepository;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftHistoryQueryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataGift {
	private DataGiftStrategy delegate;
	private DonorServiceInfo serviceInfo;
	
	@Autowired
	IDataGiftHistoryQueryRepository dataGiftHistoryQueryRepository;
	
	@Autowired
	IDataGiftHistoryCommmandRepository repo;
		
	public DataGift(DonorServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}
	
	public void setDataGiftType(DataGiftStrategy type) {
		this.delegate = type;
	}
	
	public void sendDataGift() {
		this.delegate.sendDataGift();
	}
	/*
	protected ProductGroup getProductGroup() {
		return ProductRule.getProductGroup(serviceInfo.svcMgmtNum, serviceInfo.feeProdId);
	}
	*/
	public DataGiftHistoryCount getDataGiftHistoryCount() {
		
		/*결합상품 그룹 조회 */
		ProductGroup productGroup = ProductRule.getProductGroup(serviceInfo.svcMgmtNum, serviceInfo.feeProdId);
		log.debug("productGroup [{}]", productGroup);
		
		/*선물 가능 기준조회*/
		DataGiftLimit limit = new DataGiftLimit(productGroup);
		
		/* 테스트데이터 입력 */
		
		DataGiftHistory hist = DataGiftHistory.builder()
                .svcMgmtNum("7123456789")
                .opDtm("20210501092530")
                .befrCustNum("9777755550")
                .befrProdId("NA00006404")
                .befrSvcMgmtNum("7777755555")
                .befrSvcNum("01091110424")
                .custNum("9888855550")
                .dataGiftOpStCd("1")
                .dataGiftTypCd("G1")
                .giftDataQty("1024")
                .prodId("NA00006404")
                .build();
		log.debug(hist.toString());
		repo.save(hist);
		
		
		
		/*당월 선물 이력조회 */
		
		/*
		QueryResults<Tuple> queryResults = dataGiftHistoryQueryRepository.getMonthDataGiftSendHistoryCount(serviceInfo.svcMgmtNum, "202105"); 
		List<Tuple> list = queryResults.getResults();
		  
		Map<String,Integer> map = new HashMap<>(); 
		for (Tuple tuple : list) {
		    map.put(tuple.get(0, String.class), tuple.get(1, Integer.class)); 
		}
		log.debug(map.toString());
		 */
		
		//count.setSentGeneralCount(list.);
		//settuple.get(0, String.class)
		return DataGiftHistoryCount.builder()
				                   .generalCount(limit.getGeneralCount())
				                   .extraCount(limit.getExtraCount())
				                   //.sentGeneralCount(0)
				                   //.sentExtraCount(0)
				                   .build();
				                    
	}

}
