package com.skcc.product.rest.datagift;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistory;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistoryId;

interface DataGiftRepository extends JpaRepository<DataGiftHistory, DataGiftHistoryId> {

}

@DataJpaTest
class DataGiftHistoryTest {

	@Autowired
	DataGiftRepository repo;
	
	@Test
	void InsertTest() {
		DataGiftHistory hist = DataGiftHistory.builder()
				                              .svcMgmtNum("7123456789")
				                              .opDtm("20210501092530")
				                              .afmlyGiftYn("Y")
				                              .befrCustNum("9777755550")
				                              .befrProdId("NA00006404")
				                              .befrSvcMgmtNum("7777755555")
				                              .custNum("9888855550")
				                              .dataGiftOpStCd("1")
				                              .dataGiftTypCd("G1")
				                              .giftDataQty("1024")
				                              .prodId("NA00006404")
				                              .build();				                
		repo.save(hist);		
	}

}
