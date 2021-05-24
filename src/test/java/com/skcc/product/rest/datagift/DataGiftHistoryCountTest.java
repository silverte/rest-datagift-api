package com.skcc.product.rest.datagift;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftHistoryQueryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class DataGiftHistoryCountTest {
	IDataGiftHistoryQueryRepository dataGiftHistoryQueryRepository;
	
	private DataGiftHistoryCountTest(IDataGiftHistoryQueryRepository dataGiftHistoryQueryRepository) {
		this.dataGiftHistoryQueryRepository = dataGiftHistoryQueryRepository;
	}
	
	@Test
	public void dataGiftSendHistoryCount() {
		
		/*당월 선물 이력조회 */
	//	QueryResults<Tuple> queryResults = dataGiftHistoryQueryRepository.getMonthDataGiftSendHistoryCount(Long.valueOf("7123456789"), "202105");
	//	List<Tuple> list = queryResults.getResults();
	//	log.info("[{}]", list);
		;
	}

}
